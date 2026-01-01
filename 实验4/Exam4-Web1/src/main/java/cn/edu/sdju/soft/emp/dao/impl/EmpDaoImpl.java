package cn.edu.sdju.soft.emp.dao.impl;

import cn.edu.sdju.soft.emp.bean.Emp;
import cn.edu.sdju.soft.emp.dao.EmpDao;
import cn.edu.sdju.soft.emp.utils.DatasScource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class EmpDaoImpl implements EmpDao {

    @Override
    public List<Emp> findAll() throws Exception {
        Connection connection = DatasScource.getConnection();
        ResultSet resultSet = connection.prepareStatement(
                "select id,ename,esex,dept from emp"
        ).executeQuery();

        connection.close(); // 连接关闭

        List<Emp> emps = new ArrayList<>();

        while(resultSet.next()){
            Emp emp = new Emp();
            emp.setId(resultSet.getInt("id"));
            emp.setName(resultSet.getString("ename"));
            emp.setSex(resultSet.getString("esex"));
            emp.setDept(resultSet.getString("dept"));
            emps.add(emp);
        }

        return emps;
    }
}
