package com.example.soft.spring.service;

public interface FansService {
	public void subscribe(Integer fansId,Integer publicId); // 粉丝订阅
	public void unsubscribe(Integer fansId, Integer publicId); // 取消订阅
}
