package com.example.soft.spring.test;

import java.time.LocalDateTime;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.soft.spring.dao.impl.FansDaoImpl;
import com.example.soft.spring.entity.Fans;


public class SpringTest {

	@Test
	public void test1() {
		Fans fans = new Fans();
		fans.setEmail("123123@qq.com");
		fans.setFanName("name1");
		fans.setGender("male");
		fans.setRegDate(LocalDateTime.now());
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springjdbc.xml");
		FansDaoImpl daoImpl = (FansDaoImpl)applicationContext.getBean("FansDaoImpl");
		daoImpl.addFans(fans);
	}
}
