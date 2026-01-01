package cn.edu.sdju.soft.aop.impl;

import cn.edu.sdju.soft.aop.Human;

public class Police implements Human{

	@Override
    public void sleep() {
        System.out.println("Police正在睡觉...");
    }

    @Override
    public void bath() {
        System.out.println("Police正在洗澡...");
    }

}
