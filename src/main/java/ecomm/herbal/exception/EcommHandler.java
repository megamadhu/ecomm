package ecomm.herbal.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import ecomm.herbal.controller.SignInController;

@ControllerAdvice
public class EcommHandler {

	private static Logger logger = LogManager.getLogger(SignInController.class);

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handleResourceNotFoundException(
			NoHandlerFoundException e) {
		ModelAndView modelAndView = new ModelAndView("error");
		modelAndView.addObject("errType", "404");
		logger.error("EcommHandler: handleResourceNotFoundException() {}", e);
		return modelAndView;
	}

	@ExceptionHandler(EcommException.class)
	public ModelAndView handleEcommException(EcommException e) {

		ModelAndView modelAndView = new ModelAndView("error");
		modelAndView.addObject("errType", "generic");
		logger.error("EcommHandler: handleEcommException() {}", e);
		return modelAndView;
	}

}
