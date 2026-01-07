package com.example.soft.spring.dao;

import java.util.List;

import com.example.soft.spring.entity.Fans;

public interface FansDao {
	public boolean addFans(Fans fan); // 增加粉丝
	public List<Fans> selectAllFans(); // 查找所有粉丝
	public void subscribe(Integer fansId,Integer publicId); // 粉丝订阅
	public void unsubscribe(Integer fansId, Integer publicId); // 取消订阅
}
