package com.example.soft.spring.entity;

public class PublicFans {
	private Integer fanId;
	private Boolean isSubscribedBoolean = true;
	private Integer pflId;
	private Integer publicId;
	public Integer getFanId() {
		return fanId;
	}
	public void setFanId(Integer fanId) {
		this.fanId = fanId;
	}
	public Boolean getIsSubscribedBoolean() {
		return isSubscribedBoolean;
	}
	public void setIsSubscribedBoolean(Boolean isSubscribedBoolean) {
		this.isSubscribedBoolean = isSubscribedBoolean;
	}
	public Integer getPflId() {
		return pflId;
	}
	public void setPflId(Integer pflId) {
		this.pflId = pflId;
	}
	public Integer getPublicId() {
		return publicId;
	}
	public void setPublicId(Integer publicId) {
		this.publicId = publicId;
	}
	
}
