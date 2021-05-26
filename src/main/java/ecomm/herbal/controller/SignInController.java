package ecomm.herbal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import ecomm.herbal.constants.SignInConstants;
import ecomm.herbal.entity.Signup;
import ecomm.herbal.entity.SignupKey;
import ecomm.herbal.exception.EcommException;
import ecomm.herbal.repository.SignInRepository;

@Controller
@SessionAttributes("uname")
public class SignInController {

	private static Logger logger = LogManager.getLogger(SignInController.class);

	@Autowired
	SignInRepository signInRepository;

	@GetMapping(value = "/signup")
	public ModelAndView signUpGet() throws EcommException {
		logger.info("SignInController: signUpGet()");
		ModelAndView modelAndView = new ModelAndView("signup");
		return modelAndView;
	}

	@GetMapping(value = "/signin")
	public ModelAndView signInGet() throws EcommException {
		logger.info("SignInController: signInGet()");
		ModelAndView modelAndView = new ModelAndView("signin");
		return modelAndView;
	}

	@PostMapping(value = "/signup")
	public ModelAndView signUpPost(@RequestParam(value = "name") String name,
			@RequestParam(value = "uname") String uname,
			@RequestParam(value = "pass") String pass,
			@RequestParam(value = "email") String email) throws EcommException {
		logger.info("SignInController: signUpPost()");
		ModelAndView modelAndView = null;
		Signup signUp = new Signup();
		signUp.setEmail(email);
		signUp.setName(name);
		SignupKey signupKey = new SignupKey();
		signupKey.setPassword(pass);
		signupKey.setUsername(uname);
		signUp.setSignupKey(signupKey);

		Signup unameDB = signInRepository.getByUsername(uname);
		if (StringUtils.isEmpty(unameDB)) {

			modelAndView = new ModelAndView("signin");
			signInRepository.save(signUp);
			modelAndView.addObject("msg",
					SignInConstants.REGISTRATION_SUCCESSFULL);

		} else {
			modelAndView = new ModelAndView("signup");
			modelAndView.addObject("errMsg", SignInConstants.USER_EXISTS);
		}

		return modelAndView;
	}

	@PostMapping(value = "/signin")
	public ModelAndView signInPost(@RequestParam(value = "uname") String uname,
			@RequestParam(value = "pass") String pass,
			HttpServletRequest request) throws EcommException {
		logger.info("SignInController: signInPost()");
		ModelAndView modelAndView = new ModelAndView("signin");
		Signup signUp = new Signup();
		SignupKey signupKey = new SignupKey();
		signupKey.setPassword(pass);
		signupKey.setUsername(uname);
		signUp.setSignupKey(signupKey);

		Signup unameDB = signInRepository.getByUsernamePassword(uname, pass);
		if (unameDB != null) {

			HttpSession session = request.getSession();
			session.setAttribute("uname", unameDB.getSignupKey().getUsername());
			modelAndView = new ModelAndView("index");

		} else {
			modelAndView.addObject("errMsg",
					SignInConstants.USERNAME_PASSOWRD_INVALID);
		}

		return modelAndView;
	}

	@GetMapping(value = "/signout")
	public ModelAndView signUpPost(HttpSession httpsession, SessionStatus status) {
		logger.info("SignInController: signUpPost()");
		ModelAndView modelAndView = new ModelAndView("index");
		status.setComplete();

		httpsession.invalidate();

		return modelAndView;
	}

	@GetMapping(value = "/editProfile")
	public ModelAndView editProfileGet(HttpServletRequest request)
			throws EcommException {
		logger.info("SignInController: editProfile()");
		ModelAndView modelAndView = new ModelAndView("signup");

		HttpSession session = request.getSession();
		if (session.getAttribute("uname") != null) {

			Signup unameDB = signInRepository.getByUsername(session
					.getAttribute("uname").toString());
			if (StringUtils.isEmpty(unameDB)) {

				modelAndView.addObject("errMsg", SignInConstants.USER_INVALID);

			} else {
				modelAndView.addObject("signupDB", unameDB);
			}
		}

		return modelAndView;
	}

	@PostMapping(value = "/editProfile")
	public ModelAndView editProfilePost(
			@RequestParam(value = "name") String name,
			@RequestParam(value = "uname") String uname,
			@RequestParam(value = "pass") String pass,
			@RequestParam(value = "email") String email) throws EcommException {
		logger.info("SignInController: editProfilePost()");
		ModelAndView modelAndView = new ModelAndView("signup");

		Signup signUp = new Signup();
		signUp.setEmail(email);
		signUp.setName(name);
		SignupKey signupKey = new SignupKey();
		signupKey.setPassword(pass);
		signupKey.setUsername(uname);
		signUp.setSignupKey(signupKey);

		Signup unameDB = signInRepository.saveAndFlush(signUp);
		modelAndView.addObject("msg", SignInConstants.USER_DETAILS_SAVED);
		modelAndView.addObject("signupDB", unameDB);
		return modelAndView;
	}

}
