package cn.edu.sdju.soft.exp.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.io.Reader;

public class MybatisUtil {
    private static SqlSessionFactory sessionFactory;

    static {
        try {
            String resource = "mybatis-config.xml";
            Reader reader = Resources.getResourceAsReader(resource);

            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            sessionFactory = builder.build(reader);

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("初始化MyBatis配置失败", e);
        }
    }

    public static SqlSession getSession() {
        return sessionFactory.openSession();
    }

}
