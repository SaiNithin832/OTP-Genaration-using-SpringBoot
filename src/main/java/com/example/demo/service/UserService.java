package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.entity.UserOtp;
import com.example.demo.repository.UserOTPRepository;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	UserOTPRepository userOtpRepo;
	
	@Autowired
	JavaMailSender mailSender;
	
	public void register(User user) {
		userRepo.save(user);
	}
	
	public boolean loginAndGeneration(String emailId, String password) {
		
		User user = userRepo.findByEmailId(emailId);
		if(user == null) {
			return false;
		}
		if(!user.getPassword().equals(password)) {
			return false;
		}
		
		int otpNum = new Random().nextInt(100000, 1000000);
		String otp = String.valueOf(otpNum);
		
		UserOtp userOtp = new UserOtp();
		userOtp.setOtp(otp);
		userOtp.setUserid(user.getId());
		userOtp.setCreatedTime(LocalDateTime.now());
		userOtpRepo.save(userOtp);
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(user.getEmailId());
		message.setSubject("Your Otp Code");
		message.setText("Hello" + user.getName() + "Your Otp code is: " + otp);
		mailSender.send(message);
		
		return true;
	}
	
	public boolean verifyOtp(String otp) {
		UserOtp userOtp = userOtpRepo.findByOtp(otp);
		if(userOtp == null) {
			return false;
		} 
		LocalDateTime expiryTime = userOtp.getCreatedTime().plusMinutes(3);
		
		if(LocalDateTime.now().isAfter(expiryTime)) {
			return false;
		}
		return true;
	}
	
	
}
