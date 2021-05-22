package ecomm.herbal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ecomm.herbal.entity.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

}
