package ecomm.herbal.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ecomm.herbal.constants.ProductConstants;
import ecomm.herbal.entity.Price;
import ecomm.herbal.entity.Product;
import ecomm.herbal.exception.EcommException;
import ecomm.herbal.service.PriceService;
import ecomm.herbal.service.ProductService;

@Controller
@RequestMapping(value = "/product/")
public class ProductController {
	private static Logger logger = LogManager.getLogger(ProductController.class);

	@Autowired
	ProductService productService;
	
	@Autowired
	PriceService priceService;

//	@GetMapping("{id}")
//	public ModelAndView getProductById(@RequestParam(value = "id") Long id) throws EcommException {
//		logger.info("ProductController: getProductById() {}", id);
//		if (id != null) {
//			Product product = productService.getProductById(id);
//			if (product != null) {
//				return product;
//			}
//			throw new EcommException(ProductConstants.PRODUCT_NOT_FOUND_BY_ID);
//		}
//		throw new EcommException(ProductConstants.PRODUCT_INVALID_INPUT);
//
//	}

	@GetMapping()
	public List<Product> getAllProduct() throws EcommException {
		logger.info("ProductController: getAllProduct()");
		List<Product> allProduct = productService.getAllProduct();
		if (allProduct != null) {
			return allProduct;
		}
		throw new EcommException(ProductConstants.PRODUCT_NOT_FOUND);
	}

	@PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addProduct(@RequestParam(value = "name") String name, 
			@RequestParam(value = "description") String description,
			@RequestParam(value = "price") Double price) throws EcommException {
		logger.info("ProductController: addProduct() ");
		if (StringUtils.isEmpty(name)) {
			
			Product product = new Product();
			product.setDescription(description);
			product.setName(name);
			
			Product addProduct = productService.addProduct(product);
			if (addProduct != null) {
				Price priceObj = new Price();
				priceObj.setPrice(price);
				priceObj.setProductid(addProduct);
				priceService.addPrice(priceObj);
				
				
				return new ResponseEntity<>(ProductConstants.PRODUCT_SUCCESS, HttpStatus.OK);
			}
			throw new EcommException(ProductConstants.PRODUCT_ADD_FAILED);
		}
		throw new EcommException(ProductConstants.PRODUCT_INVALID_INPUT);

	}

//	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<String> updateProduct(@RequestBody Product product) throws EcommException {
//		logger.info("ProductController: updateProduct() ");
//		if (product != null && product.getProductId() != null) {
//			Product productObj = productService.getProductById(product.getProductId());
//			if (productObj != null) {
//				Product updateProduct = productService.updateProduct(product);
//				if (updateProduct != null) {
//					return new ResponseEntity<>(ProductConstants.PRODUCT_SUCCESS, HttpStatus.OK);
//				}
//				throw new EcommException(ProductConstants.PRODUCT_UPDATE_FAILED);
//			}
//			throw new EcommException(ProductConstants.PRODUCT_NOT_FOUND_BY_ID);
//		}
//		throw new EcommException(ProductConstants.PRODUCT_INVALID_INPUT);
//	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteProductById(@PathVariable(value = "id") Long id) throws EcommException {
		logger.info("ProductController: deleteProductById() ", id);
		if (id != null) {
			try {
				productService.deleteProductById(id);
				return new ResponseEntity<>(ProductConstants.PRODUCT_SUCCESS, HttpStatus.OK);
			} catch (Exception e) {
				throw new EcommException(ProductConstants.PRODUCT_DELETE_FAILED);
			}
		}
		throw new EcommException(ProductConstants.PRODUCT_INVALID_INPUT);
	}

}
