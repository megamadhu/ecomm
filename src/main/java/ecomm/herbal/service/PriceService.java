package ecomm.herbal.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecomm.herbal.entity.Price;
import ecomm.herbal.repository.PriceRepository;

@Service
public class PriceService {

	private static Logger logger = LogManager.getLogger(PriceService.class);
	@Autowired
	PriceRepository priceRepository;

	public Price findById(Long productId) {
		logger.info("Find by id:service Price");
		Optional<Price> price = priceRepository.findById(productId);
		return price.isPresent() ? price.get() : null;
	}

	public void addPrice(Price price) {
		logger.info("Posting:service Price");
		priceRepository.save(price);
	}

	public void updatePrice(Price price) {
		logger.info("Updating:service Price");
		priceRepository.save(price);
	}

	public List<Price> findAll() {
		logger.info("Getting all:service Price");
		return priceRepository.findAll();
	}

	public void setDeleteById(Long productId) {
		logger.info("Deleting:service Price");
		priceRepository.deleteById(productId);

	}

}
