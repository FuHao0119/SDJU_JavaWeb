package com.example.soft.spring.entity;

import java.time.LocalDateTime;


public class Fans {
	private String email;
	private Integer fanId;
	private String fanName;
	private String gender;
	private LocalDateTime regDate;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getFanId() {
		return fanId;
	}
	public void setFanId(Integer fanId) {
		this.fanId = fanId;
	}
	public String getFanName() {
		return fanName;
	}
	public void setFanName(String fanName) {
		this.fanName = fanName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public LocalDateTime getRegDate() {
		return regDate;
	}
	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}
	
}
