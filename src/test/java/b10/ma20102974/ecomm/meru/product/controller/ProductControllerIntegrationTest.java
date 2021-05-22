package b10.ma20102974.ecomm.meru.product.controller;


import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.Ignore;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import ecomm.herbal.EcommHerbalApplication;
import ecomm.herbal.entity.Product;
@Ignore
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = EcommHerbalApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerIntegrationTest {

	@LocalServerPort
	private int port;

	private static TestRestTemplate restTemplate = null;
	private static HttpHeaders headers = null;

	@BeforeAll
	public static void setUpBeforeAll() throws Exception {
		restTemplate = new TestRestTemplate();
		headers = new HttpHeaders();
	}

	@AfterAll
	public static void tearDownAfterAll() throws Exception {
		restTemplate = null;
		headers = null;
	}

	@Test
	public void testGetProductById() throws InterruptedException {
//		Product product = new Product();
//		product.setProductName("Light");
//		product.setBrand("Wipro");
//		HttpEntity<Product> addEntity = new HttpEntity<Product>(product, headers);
//		ResponseEntity<String> addResponse = restTemplate.exchange(createURLWithPort("/product/"), HttpMethod.POST,
//				addEntity, String.class);
//		assertTrue(addResponse.getStatusCode().equals(HttpStatus.OK));

//		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
//		ResponseEntity<Product> response = restTemplate.exchange(createURLWithPort("/product/1"), HttpMethod.GET,
//				entity, Product.class);
//		assertTrue(response.getStatusCode().equals(HttpStatus.OK));
//		assertTrue(response.getBody() != null);
//		assertTrue(response.getBody().getProductId() == 1);
	}

//	@Test
//	public void testGetAllProduct() {
//		Product product = new Product();
//		product.setProductName("Light");
//		product.setBrand("Wipro");
//		HttpEntity<Product> addEntity = new HttpEntity<Product>(product, headers);
//		ResponseEntity<String> addResponse = restTemplate.exchange(createURLWithPort("/product/"), HttpMethod.POST,
//				addEntity, String.class);
//		assertTrue(addResponse.getStatusCode().equals(HttpStatus.OK));
//
//		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
//		ResponseEntity<List> response = restTemplate.exchange(createURLWithPort("/product/"), HttpMethod.GET, entity,
//				List.class);
//		assertTrue(response.getStatusCode().equals(HttpStatus.OK));
//		assertTrue(response.getBody() != null);
//		assertTrue(response.getBody().get(0) != null);
//	}
//
//	@Test
//	public void testAddProduct() {
//		Product product = new Product();
//		product.setProductName("Light");
//		product.setBrand("Wipro");
//		HttpEntity<Product> entity = new HttpEntity<Product>(product, headers);
//		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/product/"), HttpMethod.POST, entity,
//				String.class);
//		assertTrue(response.getStatusCode().equals(HttpStatus.OK));
//	}
//
//	@Test
//	public void testUpdateProduct() {
//		Product product = new Product();
//		product.setProductName("Light");
//		product.setBrand("Sysca");
//		HttpEntity<Product> addEntity = new HttpEntity<Product>(product, headers);
//		ResponseEntity<String> addResponse = restTemplate.exchange(createURLWithPort("/product/"), HttpMethod.POST,
//				addEntity, String.class);
//		assertTrue(addResponse.getStatusCode().equals(HttpStatus.OK));
//
//		product.setProductId(Long.valueOf(1));
//		product.setBrand("Wipro");
//		HttpEntity<Product> updateEntity = new HttpEntity<Product>(product, headers);
//		ResponseEntity<String> updateResponse = restTemplate.exchange(createURLWithPort("/product/"), HttpMethod.PUT,
//				updateEntity, String.class);
//		assertTrue(updateResponse.getStatusCode().equals(HttpStatus.OK));
//	}
//
//	@Test
//	public void testDeleteProductById() {
//		Product product = new Product();
//		product.setProductName("Light");
//		product.setBrand("Sysca");
//		HttpEntity<Product> addEntity = new HttpEntity<Product>(product, headers);
//		ResponseEntity<String> addResponse = restTemplate.exchange(createURLWithPort("/product/"), HttpMethod.POST,
//				addEntity, String.class);
//		assertTrue(addResponse.getStatusCode().equals(HttpStatus.OK));
//
//		HttpEntity<String> delEntity = new HttpEntity<String>(null, headers);
//		ResponseEntity<String> delResponse = restTemplate.exchange(createURLWithPort("/product/1"),
//				HttpMethod.DELETE, delEntity, String.class);
//		assertTrue(delResponse.getStatusCode().equals(HttpStatus.OK));
//	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

}
