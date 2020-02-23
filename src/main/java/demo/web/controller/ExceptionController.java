package demo.web.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(value = {NoHandlerFoundException.class})
	public String exceptionHandle(Exception exception) {
		System.err.println(exception);
		return "user/error";
	}
}
