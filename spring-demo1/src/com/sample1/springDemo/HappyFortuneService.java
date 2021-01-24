package com.sample1.springDemo;

public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is a great day";
	}

}
