package com.example.soft.spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.soft.spring.dao.FansDao;
import com.example.soft.spring.service.FansService;

public class SpringTestAnno {
	@Test
	public void subscribeTest() {
		// 让jack订阅官方账号1
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springjdbc2.xml");
		FansService context = (FansService)applicationContext.getBean("FansService");
		context.subscribe(18, 1);
		System.out.println("订阅任务成功执行....");
	}
	@Test
	public void unsubscribeTest() {
		// 让jack取消订阅官方账号1
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springjdbc2.xml");
		FansService context = (FansService)applicationContext.getBean("FansService");
		context.unsubscribe(18, 1);
		System.out.println("取消订阅任务成功执行....");
	}
}
