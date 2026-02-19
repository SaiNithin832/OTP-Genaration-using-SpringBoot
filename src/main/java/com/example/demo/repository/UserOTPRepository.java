package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User;
import com.example.demo.entity.UserOtp;

public interface UserOTPRepository extends JpaRepository<UserOtp, Integer>{

  UserOtp findByOtp(String otp);
}
