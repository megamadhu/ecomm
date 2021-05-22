package ecomm.herbal.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "price")
public class Price {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@ManyToOne()
	@JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
	private Product product;
	@Column(name = "price")
	private Double price;
	@Column(name = "historyprice")
	private String historyPrice;

	public String getHistoryPrice() {
		return historyPrice;
	}

	public void setHistoryPrice(String historyPrice) {
		this.historyPrice = historyPrice;
	}

	public Product getProduct() {
		return product;
	}

	public void setProductid(Product product) {
		this.product = product;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Price(Long id, @NotBlank @NotNull Product product, Double price, String historyPrice) {
		this.id = id;
		this.product = product;
		this.price = price;
		this.historyPrice = historyPrice;
	}

	public Price() {
	}

}
