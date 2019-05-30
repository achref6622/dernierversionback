package com.tnt.bourse.utils;

import org.springframework.stereotype.Component;

@Component
public class RandomNumber {

	public String generateMyNumber() {
		int aNumber = 0;
		aNumber = (int) ((Math.random() * 9999999) + 10000000);

		return String.valueOf(aNumber);
	}

}