package ecomm.herbal.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecomm.herbal.controller.ProductController;
import ecomm.herbal.entity.Product;
import ecomm.herbal.repository.ProductRepository;

@Service
public class ProductService {

	private static Logger logger = LogManager.getLogger(ProductService.class);
	@Autowired
	ProductRepository productRepository;

	public Product getProductById(Long id) {
		logger.info("ProductService: getProductById() ", id);
		Optional<Product> findById = productRepository.findById(id);
		Product product = findById.isPresent() ? findById.get() : null;
		return product;
	}

	public List<Product> getAllProduct() {
		logger.info("ProductService: getAllProduct() ");
		return productRepository.findAll();
	}

	public Product addProduct(Product product) {
		logger.info("ProductService: addProduct() ");
		return productRepository.save(product);
	}

	public Product updateProduct(Product product) {
		logger.info("ProductService: updateProduct() ");
		return productRepository.save(product);
	}

	public void deleteProductById(Long id) {
		logger.info("ProductService: deleteProductById() ", id);
		productRepository.deleteById(id);
	}

}
