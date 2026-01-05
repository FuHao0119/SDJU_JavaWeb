package cn.edu.sdju.soft.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.apache.ibatis.session.SqlSessionFactory;

import java.io.FileInputStream;
import java.io.IOException;


public class MybatisUtil {
    private static SqlSessionFactory sessionFactory;

    static {
        try {
            String resource = "src/main/java/cn/edu/sdju/soft/config/mybatis-config.xml";
            FileInputStream inputStream = new FileInputStream(resource);
            sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("初始化MyBatis配置失败", e);
        }
    }

    public static SqlSession getSession() {
        return sessionFactory.openSession();
    }

}
