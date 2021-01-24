package com.sample1.springDemo;

public class CricketCoach implements Coach {

	private FortuneService fortuneService;

	// add new fields for emails amd team
	private String emailAddress;
	private String team;

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("Cricket coach: setEmailAddress");
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("Cricket coach: setTeam");
		this.team = team;
	}

	// create no arg constructor
	public CricketCoach() {
		System.out.println("Cricket coach: working");
	}

	// setter
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Cricket coach: working");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice bowling for 15 minutes";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
