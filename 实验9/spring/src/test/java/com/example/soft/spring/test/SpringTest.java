package com.example.soft.spring.test;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.soft.spring.dao.FansDao;
import com.example.soft.spring.dao.impl.FansDaoImpl;
import com.example.soft.spring.entity.Fans;


public class SpringTest {
	
	@Test
	public void addFansTest() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springjdbc.xml");
		FansDao context = (FansDao)applicationContext.getBean("FansDaoImpl");
		Fans fans = new Fans();
		fans.setEmail("45678@qq.com");
		fans.setFanName("peter");
		fans.setGender("male");
		fans.setRegDate(LocalDateTime.now());
		context.addFans(fans);
	}
	
	@Test
	public void selectFansTest() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springjdbc.xml");
		FansDao context = (FansDao)applicationContext.getBean("FansDaoImpl");
		List<Fans> listOfFans = context.selectAllFans();
		System.out.println(listOfFans);
	}
	
	@Test
	public void subscribeTest() {
		// 让Alice订阅官方账号1
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springjdbc.xml");
		FansDao context = (FansDao)applicationContext.getBean("FansDaoImpl");
		context.subscribe(17, 1);
		System.out.println("订阅任务成功执行....");
	}
	
	@Test
	public void unsubscribeTest() {
		// 让Alice取消订阅官方账号1
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springjdbc.xml");
		FansDao context = (FansDao)applicationContext.getBean("FansDaoImpl");
		context.unsubscribe(17, 1);
		System.out.println("取消订阅任务成功执行....");
	}
	
}
