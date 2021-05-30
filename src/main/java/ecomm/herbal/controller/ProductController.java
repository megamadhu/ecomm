package ecomm.herbal.controller;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ecomm.herbal.constants.ProductConstants;
import ecomm.herbal.entity.Product;
import ecomm.herbal.exception.EcommException;
import ecomm.herbal.repository.ProductRepository;

@Controller
@RequestMapping("/product")
public class ProductController {
	private static Logger logger = LogManager
			.getLogger(ProductController.class);

	@Autowired
	ProductRepository productRepository;

	@GetMapping()
	public ModelAndView getAllProduct() throws EcommException {
		logger.info("ProductController: getAllProduct()");
		List<Product> allProduct = productRepository.findAll();
		ModelAndView modelAndView = new ModelAndView(
				ProductConstants.VIEW_PRODUCTS);
		modelAndView.addObject("allProduct", allProduct);
		return modelAndView;
	}

	@PostMapping(value = "/add")
	public ModelAndView addProduct(@RequestParam(value = "name") String name,
			@RequestParam(value = "description") String description,
			@RequestParam(value = "price") Double price) throws EcommException {
		logger.info("ProductController: addProduct() ");
		ModelAndView modelAndView = new ModelAndView(
				ProductConstants.VIEW_PRODUCTS);
		try {

			Product product = productRepository.getProductByName(name);
			if (product == null) {
				product = new Product();
				product.setDescription(description);
				product.setPrice(price);
				product.setName(name);
				product = productRepository.saveAndFlush(product);
				modelAndView.addObject("msg", ProductConstants.PRODUCT_SUCCESS);
			} else {
				String historyPrice = product.getHistoryPrice();
				JSONArray historyArr = new JSONArray();
				if (!StringUtils.isEmpty(historyPrice)) {
					historyArr = new JSONArray(historyPrice);
				}
				historyArr = addPriceHistory(product, historyArr);

				product.setDescription(description);
				product.setPrice(price);
				product.setName(name);
				product.setHistoryPrice(historyArr.toString());
				product = productRepository.saveAndFlush(product);
				modelAndView.addObject("msg", ProductConstants.PRODUCT_SUCCESS);
			}

		} catch (Exception e) {
			logger.error(ProductConstants.PRODUCT_ADD_FAILED, e);
			modelAndView.addObject("errMsg",
					ProductConstants.PRODUCT_ADD_FAILED);
		}

		List<Product> allProduct = productRepository.findAll();
		modelAndView.addObject("allProduct", allProduct);
		return modelAndView;

	}

	private JSONArray addPriceHistory(Product product, JSONArray historyArr) {
		JSONObject history = new JSONObject();
		history.put("price", product.getPrice());
		String strDate = ProductConstants.DATE_DD_MM_YYYY.format(new Date());
		history.put("date", strDate);
		historyArr.put(history);
		return historyArr;
	}

	@PostMapping("/delete")
	public ModelAndView deleteProductById(
			@RequestParam(value = "productId") Long id) throws EcommException {
		logger.info("ProductController: deleteProductById(){} ", id);
		ModelAndView modelAndView = new ModelAndView(
				ProductConstants.VIEW_PRODUCTS);
		if (id != null) {
			try {
				productRepository.deleteById(id);
				modelAndView.addObject("msg", ProductConstants.PRODUCT_SUCCESS);
			} catch (Exception e) {
				logger.error(ProductConstants.PRODUCT_DELETE_FAILED, e);
				modelAndView.addObject("errMsg",
						ProductConstants.PRODUCT_DELETE_FAILED);
			}
		} else {
			logger.error(ProductConstants.PRODUCT_INVALID_INPUT);
			modelAndView.addObject("errMsg",
					ProductConstants.PRODUCT_INVALID_INPUT);
		}
		List<Product> allProduct = productRepository.findAll();
		modelAndView.addObject("allProduct", allProduct);

		return modelAndView;
	}

}
