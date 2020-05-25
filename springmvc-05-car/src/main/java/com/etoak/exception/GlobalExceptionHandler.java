package com.etoak.exception;

import org.jboss.logging.Message;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

/*全局异常处理器*/
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ParamException.class)
	public ModelAndView handleParamException(ParamException e) {
		
		String message = e.getMessage();
		log.error(message,e);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("paramError",message);
		
		mv.setViewName("car/add");
		return mv;
	}
}
