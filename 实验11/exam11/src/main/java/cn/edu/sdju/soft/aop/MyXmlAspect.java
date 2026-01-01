package cn.edu.sdju.soft.aop;


public class MyXmlAspect {
    // 前置增强方法
    public void takeOffCloth() {
        System.out.println("脱衣服 (XML前置通知)");
    }

    // 后置增强方法
    public void putOnCloth() {
        System.out.println("穿衣服 (XML后置通知)");
    }
}
