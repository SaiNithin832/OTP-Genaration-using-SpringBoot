package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class UserOtp {
     
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 int otpid;
	
	@Column
	 String otp;
	
	@Column
	 int userid;
	
	@Column
	LocalDateTime createdTime;
	 
	 public UserOtp() {
		super();
		// TODO Auto-generated constructor stub
	 }

	 public UserOtp(int otpid, String otp, int userid, LocalDateTime createdTime) {
		super();
		this.otpid = otpid;
		this.otp = otp;
		this.userid = userid;
		this.createdTime = createdTime;
	 }

	 public int getOtpid() {
		 return otpid;
	 }

	 public void setOtpid(int otpid) {
		 this.otpid = otpid;
	 }

	 public String getOtp() {
		 return otp;
	 }

	 public void setOtp(String otp) {
		 this.otp = otp;
	 }

	 public int getUserid() {
		 return userid;
	 }

	 public void setUserid(int userid) {
		 this.userid = userid;
	 }

	 public LocalDateTime getCreatedTime() {
		 return createdTime;
	 }

	 public void setCreatedTime(LocalDateTime createdTime) {
		 this.createdTime = createdTime;
	 }

	 
	 
}
