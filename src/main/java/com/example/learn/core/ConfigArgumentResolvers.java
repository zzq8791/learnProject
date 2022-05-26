package com.example.learn.core;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;
import org.springframework.web.servlet.mvc.method.annotation.ServletModelAttributeMethodProcessor;

import com.example.learn.core.argres.CurrentUserMethodArgumentResolver;
import com.example.learn.core.handle.MyHandlerMethodArgumentResolver;


/**
 *  * 解析器放置第一位
 */



@Configuration
public class ConfigArgumentResolvers {

	private final RequestMappingHandlerAdapter requestMappingHandlerAdapter;
	@Autowired
	private HttpMessageConverters httpMessageConverters;
	
    public ConfigArgumentResolvers(RequestMappingHandlerAdapter requestMappingHandlerAdapter) {
        this.requestMappingHandlerAdapter = requestMappingHandlerAdapter;
    }

    @PostConstruct
    private void addArgumentResolvers() {
        // 获取到的是不可变的集合
        List<HandlerMethodArgumentResolver> argumentResolvers =
                                                    requestMappingHandlerAdapter.getArgumentResolvers();
     //   MyHandlerMethodArgumentResolver myHandlerMethodArgumentResolver =
                                 //                   getMyHandlerMethodArgumentResolver(argumentResolvers);
        // ha.getArgumentResolvers()获取到的是不可变的集合,所以我们需要新建一个集合来放置参数解析器
        List<HandlerMethodArgumentResolver> myArgumentResolvers =
                                                    new ArrayList<>(argumentResolvers.size() + 1);
        // 将自定义的解析器，放置在第一个； 并保留原来的解析器
        myArgumentResolvers.add(new CurrentUserMethodArgumentResolver());
        myArgumentResolvers.add(myHandlerMethodArgumentResolver());
        myArgumentResolvers.addAll(argumentResolvers);
        requestMappingHandlerAdapter.setArgumentResolvers(myArgumentResolvers);
    }
    
    @Bean
    public MyHandlerMethodArgumentResolver myHandlerMethodArgumentResolver() {
        return new MyHandlerMethodArgumentResolver (httpMessageConverters.getConverters());
    }
	
    /**
     * 获取MyHandlerMethodArgumentResolver实例
     */
  /*  private MyHandlerMethodArgumentResolver getMyHandlerMethodArgumentResolver(
            List<HandlerMethodArgumentResolver> argumentResolversList) {
        // 解析Content-Type为application/json的默认解析器
        RequestResponseBodyMethodProcessor requestResponseBodyMethodProcessor = null;
        // 解析Content-Type为application/x-www-form-urlencoded的默认解析器
        ServletModelAttributeMethodProcessor servletModelAttributeMethodProcessor = null;
        if (argumentResolversList == null) {
            throw new RuntimeException("argumentResolverList must not be null!");
        }
        for (HandlerMethodArgumentResolver argumentResolver : argumentResolversList) {
            if (requestResponseBodyMethodProcessor != null && servletModelAttributeMethodProcessor != null) {
                break;
            }
            if (argumentResolver instanceof RequestResponseBodyMethodProcessor) {
                requestResponseBodyMethodProcessor = (RequestResponseBodyMethodProcessor)argumentResolver;
                continue;
            }
            if (argumentResolver instanceof ServletModelAttributeMethodProcessor) {
                servletModelAttributeMethodProcessor = (ServletModelAttributeMethodProcessor)argumentResolver;
            }
        }
        if (requestResponseBodyMethodProcessor == null || servletModelAttributeMethodProcessor == null) {
            throw new RuntimeException("requestResponseBodyMethodProcessor and "
                    + " servletModelAttributeMethodProcessor must not be null!");
        }
        return new MyHandlerMethodArgumentResolver(requestResponseBodyMethodProcessor,
                servletModelAttributeMethodProcessor);
    }*/
    
}
