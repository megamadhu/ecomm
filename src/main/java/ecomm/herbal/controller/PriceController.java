package ecomm.herbal.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import ecomm.herbal.constants.PriceConstants;
import ecomm.herbal.constants.ProductConstants;
import ecomm.herbal.entity.Price;
import ecomm.herbal.entity.Product;
import ecomm.herbal.exception.EcommException;
import ecomm.herbal.service.PriceService;
import ecomm.herbal.service.ProductService;

@Controller
@RequestMapping(path = "/price/")
public class PriceController {

	private static Logger logger = LogManager.getLogger(PriceController.class);
	@Autowired
	PriceService priceService;
	
	@Autowired
	ProductService productService;

	@Autowired
	RestTemplateBuilder restTemplateBuilder;

//	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<String> createPrice(@RequestBody Price price) throws EcommException {
//		logger.info("Posting:controller Price");
//		if (price != null && price.getProductId() != null) {
//			Price priceObj = priceService.findById(price.getProductId());
//			if (priceObj == null) {
//				Product product = productService.getProductById(price.getProductId());
//				if (product != null) {
//					try {
//						priceService.addPrice(price);
//						return new ResponseEntity<>(PriceConstants.PRICE_SUCCESS, HttpStatus.OK);
//					} catch (Exception ex) {
//						throw new EcommException(PriceConstants.PRICE_ADD_FAILED);
//					}
//				}
//				throw new EcommException(ProductConstants.PRODUCT_NOT_FOUND);
//			}
//			throw new EcommException(ProductConstants.PRODUCT_ALREADY_EXIST);
//		}
//		throw new EcommException(PriceConstants.PRICE_INVALID_INPUT);
//
//	}



//	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<String> updateInventory(@RequestBody Price price) throws EcommException {
//		logger.info("Updating:controller Price");
//		if (price != null && price.getProductId() != null) {
//			Price priceObj = priceService.findById(price.getProductId());
//			if (priceObj != null) {
//				try {
//					priceService.updatePrice(price);
//					return new ResponseEntity<>(PriceConstants.PRICE_SUCCESS, HttpStatus.OK);
//				} catch (Exception ex) {
//					throw new EcommException(PriceConstants.PRICE_UPDATE_FAILED);
//				}
//			}
//			throw new EcommException(PriceConstants.PRICE_NOT_FOUND_BY_ID);
//		}
//		throw new EcommException(PriceConstants.PRICE_INVALID_INPUT);
//
//	}

	@GetMapping
	public List<Price> getPriceDetails() throws EcommException {
		logger.info("Getting Price");
		List<Price> allPrice = priceService.findAll();
		if (allPrice != null) {
			return allPrice;
		}
		throw new EcommException(PriceConstants.PRICE_NOT_FOUND);
	}

	@GetMapping("{id}")
	public Price getPriceById(@PathVariable(value = "id") Long productId) throws EcommException {
		logger.info("Getting:controller Price by id");
		if (productId != null) {
			Price price = priceService.findById(productId);
			if (price != null) {
				return price;
			}
			throw new EcommException(PriceConstants.PRICE_NOT_FOUND_BY_ID);
		}
		throw new EcommException(PriceConstants.PRICE_INVALID_INPUT);
	}

//	@DeleteMapping("{id}")
//	public ResponseEntity<String> deletePriceById(@PathVariable(value = "id") Long productId) throws EcommException {
//		logger.info("Deleting:controller Price");
//		Price priceObj = priceService.findById(productId);
//		if (priceObj != null && priceObj.getProductId() != null) {
//			try {
//				priceService.setDeleteById(productId);
//				return new ResponseEntity<>(PriceConstants.PRICE_SUCCESS, HttpStatus.OK);
//			} catch (Exception e) {
//				throw new EcommException(PriceConstants.PRICE_DELETE_FAILED);
//			}
//		}
//		throw new EcommException(PriceConstants.PRICE_NOT_FOUND_BY_ID);
//
//	}
}
