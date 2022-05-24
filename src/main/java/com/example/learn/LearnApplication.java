package com.example.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.example.learn.core.InitializingAdvice;

@ComponentScan("com.example.learn.*")
@SpringBootApplication
public class LearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnApplication.class, args);
	}

	/*@Bean
    public InitializingAdvice getResponseBodyWrap() {
        return new InitializingAdvice();
    }*/
	
}
