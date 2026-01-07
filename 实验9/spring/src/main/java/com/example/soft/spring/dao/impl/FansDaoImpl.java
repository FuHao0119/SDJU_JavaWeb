package com.example.soft.spring.dao.impl;

import java.lang.System.Logger;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.soft.spring.dao.FansDao;
import com.example.soft.spring.entity.Fans;

public class FansDaoImpl implements FansDao{
	
	public JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public boolean addFans(Fans fan) {
		String sql = "insert into tb_fans (fan_name,gender,email,reg_date) values (?,?,?,?)";
		jdbcTemplate.update(sql,fan.getFanName(),fan.getGender(),fan.getEmail(),fan.getRegDate());
		return true;
	}

	@Override
	public List<Fans> selectAllFans() {
		String sql = "SELECT fan_id, fan_name, gender, email, reg_date FROM tb_fans";
        RowMapper<Fans> rowMapper = new BeanPropertyRowMapper<>(Fans.class);
        return jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
	public void subscribe(Integer fansId, Integer publicId) {
		String sql1 = "insert into tb_fan_subscriptions (fan_id,public_id,subscription_date) values (?,?,?)";
		String sql2 = "insert into tb_public_fans (public_id,fan_id) values (?,?)";
		jdbcTemplate.update(sql1,fansId,publicId,LocalDateTime.now());
		System.out.println("操作1执行....");
		// throw new RuntimeException("--- 模拟业务异常，测试事务回滚 ---");
		jdbcTemplate.update(sql2,publicId,fansId);
		System.out.println("操作2执行....");
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
	public void unsubscribe(Integer fansId, Integer publicId) {
		String sql1 = "delete from tb_fan_subscriptions where fan_id = ? and public_id = ?";
		jdbcTemplate.update(sql1,fansId,publicId);
		System.out.println("操作1执行....");
		String sql2 = "update tb_public_fans set is_subscribed = 0 where fan_id = ? and public_id = ?";
		jdbcTemplate.update(sql2,fansId,publicId);
		System.out.println("操作2执行....");
	}

}
