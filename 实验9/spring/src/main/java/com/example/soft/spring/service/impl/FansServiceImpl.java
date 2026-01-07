package com.example.soft.spring.service.impl;

import com.example.soft.spring.dao.FansDao;
import com.example.soft.spring.service.FansService;

public class FansServiceImpl implements FansService{
	
	public FansDao fansDao;
	
	public void setFansDao(FansDao fansDao) {
		this.fansDao = fansDao;
	}

	@Override
	public void subscribe(Integer fansId, Integer publicId) {
		fansDao.subscribe(fansId, publicId);
	}

	@Override
	public void unsubscribe(Integer fansId, Integer publicId) {
		fansDao.unsubscribe(fansId, publicId);
	}

}
