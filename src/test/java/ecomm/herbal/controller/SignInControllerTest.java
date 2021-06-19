package ecomm.herbal.controller;

import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

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

import ecomm.herbal.constants.SignInConstants;
import ecomm.herbal.entity.Signup;
import ecomm.herbal.entity.SignupKey;
import ecomm.herbal.repository.SignInRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SignInControllerTest {

	private MockMvc mockMvc;

	@Mock
	private SignInRepository signInRepository;

	@InjectMocks
	private SignInController signInController;

	@Before
	public void setup() {

		// this must be called for the @Mock annotations above to be processed
		// and for the mock service to be injected into the controller under
		// test.
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(signInController)
				.build();

	}

	@Test
	public void testSignUpGet() {
		try {

			this.mockMvc.perform(get("/signup")).andExpect(status().isOk())
					.andExpect(view().name(SignInConstants.VIEW_REGISTER));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testSignInGet() {
		try {

			this.mockMvc.perform(get("/signin")).andExpect(status().isOk())
					.andExpect(view().name(SignInConstants.VIEW_LOGIN));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testSignUpPost() {
		try {

			Mockito.when(signInRepository.getByUsername("madhumita"))
					.thenReturn(null);
			this.mockMvc
					.perform(
							post("/signup").param("name", "Madhumita")
									.param("uname", "madhumita")
									.param("pass", "madhumita")
									.param("email", "madhu@gmail.com"))
					.andExpect(status().isOk())
					.andExpect(view().name(SignInConstants.VIEW_LOGIN))
					.andExpect(
							model().attribute("msg",
									SignInConstants.REGISTRATION_SUCCESSFULL));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testSignUpPostWhenUserExists() {
		try {
			Signup signUp = new Signup();
			signUp.setEmail("madhu@gmail.com");
			signUp.setName("Madhumita");
			SignupKey signupKey = new SignupKey();
			signupKey.setPassword("madhumita");
			signupKey.setUsername("madhumita");
			signUp.setSignupKey(signupKey);

			Mockito.when(signInRepository.getByUsername("madhumita"))
					.thenReturn(signUp);
			this.mockMvc
					.perform(
							post("/signup").param("name", "Madhumita")
									.param("uname", "madhumita")
									.param("pass", "madhumita")
									.param("email", "madhu@gmail.com"))
					.andExpect(status().isOk())
					.andExpect(view().name(SignInConstants.VIEW_REGISTER))
					.andExpect(
							model().attribute("errMsg",
									SignInConstants.USER_EXISTS));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testSignInPost() {
		try {

			Signup signUp = new Signup();
			signUp.setEmail("madhu@gmail.com");
			signUp.setName("Madhumita");
			SignupKey signupKey = new SignupKey();
			signupKey.setPassword("madhumita");
			signupKey.setUsername("madhumita");
			signUp.setSignupKey(signupKey);

			Mockito.when(
					signInRepository.getByUsernamePassword("madhumita",
							"madhumita")).thenReturn(signUp);
			this.mockMvc
					.perform(
							post("/signin").param("uname", "madhumita").param(
									"pass", "madhumita"))
					.andExpect(status().isOk())
					.andExpect(view().name(SignInConstants.VIEW_INDEX));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testSignInPostWhenUserInvalid() {
		try {

			Mockito.when(
					signInRepository.getByUsernamePassword("madhumita",
							"madhumita")).thenReturn(null);
			this.mockMvc
					.perform(
							post("/signin").param("uname", "madhumita").param(
									"pass", "madhumita"))
					.andExpect(view().name(SignInConstants.VIEW_LOGIN))
					.andExpect(
							model().attribute("errMsg",
									SignInConstants.USERNAME_PASSOWRD_INVALID));
			;
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testSignOutGet() {
		try {

			this.mockMvc.perform(get("/signout/")).andExpect(status().isOk())
					.andExpect(view().name(SignInConstants.VIEW_INDEX));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testEditProfileGet() {
		try {

			this.mockMvc.perform(get("/editProfile"))
					.andExpect(status().isOk())
					.andExpect(view().name(SignInConstants.VIEW_REGISTER));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testEditProfileGetWithSessionAttribute() {
		try {

			Signup signUp = new Signup();
			signUp.setName("Madhumita");

			Mockito.when(signInRepository.getByUsername("madhumita"))
					.thenReturn(signUp);
			this.mockMvc
					.perform(
							get("/editProfile").sessionAttr("uname",
									"madhumita")).andExpect(status().isOk())
					.andExpect(view().name(SignInConstants.VIEW_REGISTER))
					.andExpect(model().attributeExists("signupDB"));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testEditProfileGetWithInvalidUser() {
		try {

			Mockito.when(signInRepository.getByUsername("madhumita"))
					.thenReturn(null);
			this.mockMvc
					.perform(
							get("/editProfile").sessionAttr("uname",
									"madhumita"))
					.andExpect(status().isOk())
					.andExpect(view().name(SignInConstants.VIEW_REGISTER))
					.andExpect(
							model().attribute("errMsg",
									SignInConstants.USER_INVALID));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testEditProfilePost() {
		try {
			Signup signUp = new Signup();
			signUp.setEmail("madhu@gmail.com");
			signUp.setName("Madhumita");
			SignupKey signupKey = new SignupKey();
			signupKey.setPassword("madhumita");
			signupKey.setUsername("madhumita");
			signUp.setSignupKey(signupKey);

			Mockito.when(signInRepository.saveAndFlush(signUp)).thenReturn(
					signUp);
			this.mockMvc
					.perform(
							post("/editProfile").param("name", "Madhumita")
									.param("uname", "madhumita")
									.param("pass", "madhumita")
									.param("email", "madhu@gmail.com"))
					.andExpect(status().isOk())
					.andExpect(view().name(SignInConstants.VIEW_REGISTER))
					.andExpect(
							model().attribute("msg",
									SignInConstants.USER_DETAILS_SAVED));
		} catch (Exception e) {
			fail();
		}
	}

}
