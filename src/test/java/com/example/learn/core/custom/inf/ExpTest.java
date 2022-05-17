package com.example.learn.core.custom.inf;

import com.example.learn.core.custom.enums.ResponseEnum;

public class ExpTest {

	public static void main(String[] args) {
		checkNotNull(null);
	}
	
	private static void  checkNotNull(TestBean licence) {
        ResponseEnum.LICENCE_NOT_FOUND.assertNotNull(licence,"ccc");
    }
}
