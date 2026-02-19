package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
     int id;
	@Column
     String name;
	@Column(name = "phone_num")
     int phoneNum;
	@Column(name = "email_id")
     String emailId;
	@Column
     String password;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String name, int phoneNum, String emailId, String password) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNum = phoneNum;
		this.emailId = emailId;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(int phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
     
}
