package ecomm.herbal.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.NoHandlerFoundException;

import ecomm.herbal.constants.ProductConstants;
import ecomm.herbal.entity.Product;
import ecomm.herbal.repository.ProductRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

	private MockMvc mockMvc;

	@Mock
	private ProductRepository productRepository;

	@InjectMocks
	private ProductController productController;

	@Before
	public void setup() {

		// this must be called for the @Mock annotations above to be processed
		// and for the mock service to be injected into the controller under
		// test.
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(productController)
				.build();

	}

	@Test
	public void testGetAllProduct() {
		try {

			List<Product> allProduct = new ArrayList<Product>();
			Product product = new Product();
			product.setName("bodymos");
			allProduct.add(product);

			Mockito.when(productRepository.findAll()).thenReturn(allProduct);

			this.mockMvc.perform(get("/product")).andExpect(status().isOk())
					.andExpect(view().name(ProductConstants.VIEW_PRODUCTS));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testAddProduct() {
		try {
			Mockito.when(productRepository.getProductByName("bodymos"))
					.thenReturn(null);
			Product product = new Product();
			product.setName("bodymos");
			product.setDescription("");
			product.setPrice(15.50);
			Mockito.when(productRepository.saveAndFlush(product)).thenReturn(
					product);

			this.mockMvc
					.perform(
							post("/product/add")
									.param("name", "bodymos")
									.param("description",
											"a mosquito repellent")
									.param("price", "13.50"))
					.andExpect(status().isOk())
					.andExpect(
							model().attribute("msg",
									ProductConstants.PRODUCT_SUCCESS));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testUpdateProduct() {
		try {
			Product product = new Product();
			product.setName("bodymos");
			product.setDescription("");
			product.setPrice(15.50);
			JSONArray arr = new JSONArray();
			JSONObject price = new JSONObject();
			price.put("price", "16.50");
			price.put("date",
					ProductConstants.DATE_DD_MM_YYYY.format(new Date()));
			product.setHistoryPrice(arr.toString());

			Mockito.when(productRepository.getProductByName("bodymos"))
					.thenReturn(product);

			this.mockMvc
					.perform(
							post("/product/add")
									.param("name", "bodymos")
									.param("description",
											"a mosquito repellent")
									.param("price", "13.50"))
					.andExpect(status().isOk())
					.andExpect(
							model().attribute("msg",
									ProductConstants.PRODUCT_SUCCESS));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testUpdateProductFailed() {
		try {
			Product product = new Product();
			product.setName("bodymos");
			product.setDescription("");
			product.setPrice(15.50);
			JSONObject price = new JSONObject();
			price.put("price", "16.50");
			price.put("date",
					ProductConstants.DATE_DD_MM_YYYY.format(new Date()));
			product.setHistoryPrice(price.toString());

			Mockito.when(productRepository.getProductByName("bodymos"))
					.thenReturn(product);

			this.mockMvc
					.perform(
							post("/product/add")
									.param("name", "bodymos")
									.param("description",
											"a mosquito repellent")
									.param("price", "13.50"))
					.andExpect(status().isOk())
					.andExpect(
							model().attribute("errMsg",
									ProductConstants.PRODUCT_ADD_FAILED));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testDeleteProductById() {
		try {
			Mockito.doNothing().when(productRepository).deleteById((long) 1);
			this.mockMvc
					.perform(post("/product/delete").param("productId", "1"))
					.andExpect(status().isOk())
					.andExpect(
							model().attribute("msg",
									ProductConstants.PRODUCT_SUCCESS));
		} catch (Exception e) {
			fail();
		}
	}

}
