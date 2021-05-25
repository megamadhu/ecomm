package ecomm.herbal.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class EcommHandler {
	
	
	
	 @ExceptionHandler(NoHandlerFoundException.class)
	    public ModelAndView handleResourceNotFoundException(NoHandlerFoundException e) {
		 ModelAndView modelAndView = new ModelAndView("error");
		return modelAndView;
	    }

}
