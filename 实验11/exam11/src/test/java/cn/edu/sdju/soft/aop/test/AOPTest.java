package cn.edu.sdju.soft.aop.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.edu.sdju.soft.aop.Human;


public class AOPTest {
	@Test
	public void testAopXml() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
	    Human doctor = (Human) context.getBean("doctorBean");
	    System.out.println("--- XML 方式测试 ---");
	    doctor.bath();
	    doctor.sleep();
	    
	    Human police = (Human) context.getBean("policeBean");
	    police.bath();
	    police.sleep();
	}
}
