package com.example.soft.spring.dao.impl;

import java.lang.System.Logger;

import org.springframework.jdbc.core.JdbcTemplate;

import com.example.soft.spring.dao.FansDao;
import com.example.soft.spring.entity.Fans;

public class FansDaoImpl implements FansDao{
	
	public JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	@Override
	public boolean addFans(Fans fan) {
		jdbcTemplate.execute("select * from tb_fans");
		System.out.println("123123123.......");
		return false;
	}

}
