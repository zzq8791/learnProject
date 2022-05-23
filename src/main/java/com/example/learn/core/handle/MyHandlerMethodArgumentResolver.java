package com.example.learn.core.handle;

import java.util.List;

import org.springframework.core.MethodParameter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.AbstractMessageConverterMethodArgumentResolver;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyHandlerMethodArgumentResolver extends AbstractMessageConverterMethodArgumentResolver {
	public MyHandlerMethodArgumentResolver(List<HttpMessageConverter<?>> converters) {
		super(converters);
	}

    @Override
	public Object resolveArgument(MethodParameter arg0, ModelAndViewContainer arg1, NativeWebRequest arg2,
			WebDataBinderFactory arg3) throws Exception {
		// TODO Auto-generated method stub
    	log.info("arg0：{}",arg0);
    	log.info("arg1：{}",arg1);
    	log.info("arg2：{}",arg2);
		return null;
	}

	@Override
	public boolean supportsParameter(MethodParameter arg0) {
		// TODO Auto-generated method stub
		return true;
	}


}
