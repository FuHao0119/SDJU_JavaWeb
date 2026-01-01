package cn.edu.sdju.soft.aop.impl;

import cn.edu.sdju.soft.aop.Human;

public class Doctor implements Human{

	@Override
    public void sleep() {
        System.out.println("Doctor正在睡觉...");
    }

    @Override
    public void bath() {
        System.out.println("Doctor正在洗澡...");
    }

}
