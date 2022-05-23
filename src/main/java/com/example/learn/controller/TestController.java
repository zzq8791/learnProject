package com.example.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/")
@Controller
public class TestController {

	@RequestMapping("/test")
	@ResponseBody
	public TestParam getStr(@RequestBody TestParam str){
		log.info("进入controller");
		// ResponseEnum.LICENCE_NOT_FOUND.assertNotNull(null,"ccc");
		log.info("进入controller str: {}",str);
		return str;
	}
	
}
