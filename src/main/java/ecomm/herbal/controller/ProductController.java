package ecomm.herbal.controller;

import java.util.Date;
import java.util.List;

import javax.websocket.server.PathParam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
import ecomm.herbal.service.ProductService;

@Controller
@RequestMapping(value = "/product/")
public class ProductController {
	private static Logger logger = LogManager.getLogger(ProductController.class);

	@Autowired
	ProductService productService;

	@GetMapping()
	public ModelAndView getAllProduct() throws EcommException {
		logger.info("ProductController: getAllProduct()");
		try {
			List<Product> allProduct = productService.getAllProduct();
			ModelAndView modelAndView = new ModelAndView("products");
			modelAndView.addObject("allProduct", allProduct);
			return modelAndView;
		} catch (Exception e) {
			throw new EcommException(ProductConstants.PRODUCT_NOT_FOUND);

		}
	}

	@PostMapping(value = "/add", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ModelAndView addProduct(@RequestParam(value = "name") String name,
			@RequestParam(value = "description") String description, @RequestParam(value = "price") Double price) {
		logger.info("ProductController: addProduct() ");
		ModelAndView modelAndView = new ModelAndView("products");
		try {

			Product product = productService.getProductByName(name);
			if (product == null) {
				product = new Product();
				product.setDescription(description);
				product.setPrice(price);
				product.setName(name);
				product = productService.addProduct(product);
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
				product = productService.updateProduct(product);
				modelAndView.addObject("msg", ProductConstants.PRODUCT_SUCCESS);
			}

		} catch (Exception e) {
			logger.error(ProductConstants.PRODUCT_ADD_FAILED, e);
			modelAndView.addObject("errMsg", ProductConstants.PRODUCT_ADD_FAILED);
		}

		List<Product> allProduct = productService.getAllProduct();
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

	@GetMapping("/delete")
	public ModelAndView deleteProductById(@PathParam(value = "id") Long id) throws EcommException {
		logger.info("ProductController: deleteProductById(){} ", id);
		ModelAndView modelAndView = new ModelAndView("products");
		if (id != null) {
			try {
				productService.deleteProductById(id);

			} catch (Exception e) {
				logger.error(ProductConstants.PRODUCT_DELETE_FAILED, e);
				modelAndView.addObject("errMsg", ProductConstants.PRODUCT_DELETE_FAILED);
			}
		} else {
			logger.error(ProductConstants.PRODUCT_INVALID_INPUT);
			modelAndView.addObject("errMsg", ProductConstants.PRODUCT_INVALID_INPUT);
		}
		List<Product> allProduct = productService.getAllProduct();
		modelAndView.addObject("allProduct", allProduct);

		return modelAndView;
	}

}
