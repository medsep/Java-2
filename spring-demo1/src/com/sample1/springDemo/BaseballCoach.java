package com.sample1.springDemo;

public class BaseballCoach implements Coach {

	// define a private field for fortine
	private FortuneService fortuneService;

	// define a constructor for dependency injection
	public BaseballCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practice";
	}

	@Override
	public String getDailyFortune() {
		// use fortune service to get a fortune
		return fortuneService.getFortune();
	}
}
