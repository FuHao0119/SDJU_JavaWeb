package cn.edu.sdju.soft.emp.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class DatasScource {
    public static Connection getConnection() throws Exception {
        InputStream input = DatasScource.class.getClassLoader().getResourceAsStream("druid.properties");
        Properties prop = new Properties();
        prop.load(input);
        javax.sql.DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        return dataSource.getConnection();
    }
}
