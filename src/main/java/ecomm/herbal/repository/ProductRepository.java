package ecomm.herbal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ecomm.herbal.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	Product getProductByName(String name);

}
