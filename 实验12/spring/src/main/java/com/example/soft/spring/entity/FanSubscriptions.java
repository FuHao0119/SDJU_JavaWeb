package com.example.soft.spring.entity;

import java.time.LocalDateTime;

public class FanSubscriptions {
	private Integer fanId;
	private Integer fsId;
	private Integer publicId;
	private LocalDateTime subscriptionDate;
	public Integer getFanId() {
		return fanId;
	}
	public void setFanId(Integer fanId) {
		this.fanId = fanId;
	}
	public Integer getFsId() {
		return fsId;
	}
	public void setFsId(Integer fsId) {
		this.fsId = fsId;
	}
	public Integer getPublicId() {
		return publicId;
	}
	public void setPublicId(Integer publicId) {
		this.publicId = publicId;
	}
	public LocalDateTime getSubscriptionDate() {
		return subscriptionDate;
	}
	public void setSubscriptionDate(LocalDateTime subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
	}
	
}
