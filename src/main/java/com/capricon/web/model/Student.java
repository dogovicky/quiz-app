package com.capricon.web.model;

public class Student {
	
	private String FirstName;
	private String LastName;
	private String RegNo;
	private String Email;
	private String Password;
	private int Phone;
	
	
	public Student() {
		
	}


	public Student(String firstName, String lastName, String regNo, String email, String password, int phone) {
		
		FirstName = firstName;
		LastName = lastName;
		RegNo = regNo;
		Email = email;
		Password = password;
		Phone = phone;
	}


	public String getFirstName() {
		return FirstName;
	}


	public void setFirstName(String firstName) {
		FirstName = firstName;
	}


	public String getLastName() {
		return LastName;
	}


	public void setLastName(String lastName) {
		LastName = lastName;
	}


	public String getRegNo() {
		return RegNo;
	}


	public void setRegNo(String regNo) {
		RegNo = regNo;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	public String getPassword() {
		return Password;
	}


	public void setPassword(String password) {
		Password = password;
	}


	public int getPhone() {
		return Phone;
	}


	public void setPhone(int phone) {
		Phone = phone;
	}
	
	
	

}
