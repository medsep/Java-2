package com.testTags.jsp.tagDemo;

public class Student {

	private String firstName;
	private String lastName;
	private boolean goldCustomer;

	public Student(String firstName, String lastName, boolean goldCustomer) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.goldCustomer = goldCustomer;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isgoldCustomer() {
		return goldCustomer;
	}

	public void setgoldCustomer(boolean goldCustomer) {
		this.goldCustomer = goldCustomer;
	}

}