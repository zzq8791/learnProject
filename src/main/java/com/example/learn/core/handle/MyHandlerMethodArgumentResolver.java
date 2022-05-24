package com.example.learn.core.handle;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.AbstractMessageConverterMethodArgumentResolver;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class MyHandlerMethodArgumentResolver implements  HandlerMethodArgumentResolver  {

  /*  public MyHandlerMethodArgumentResolver(List<HttpMessageConverter<?>> converters) {
		super(converters);
		// TODO Auto-generated constructor stub
	}*/

	@Override
	public Object resolveArgument(MethodParameter arg0, ModelAndViewContainer arg1, NativeWebRequest arg2,
			WebDataBinderFactory arg3) throws Exception {
		// TODO Auto-generated method stub
    	log.info("arg0：{}",arg0);
    	log.info("arg1：{}",arg1);
    	log.info("arg2：{}",arg2);
		return arg0;
	}

	@Override
	public boolean supportsParameter(MethodParameter arg0) {
		// TODO Auto-generated method stub
		log.info("supportsParameter :{}",arg0);
		return true;
	}


}
