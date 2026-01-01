package cn.edu.sdju.soft.emp.dao.impl;

import cn.edu.sdju.soft.emp.dao.UserDao;
import cn.edu.sdju.soft.emp.utils.DatasScource;
import cn.edu.sdju.soft.emp.utils.MD5Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl implements UserDao {
    @Override
    public boolean checkNameAndPass(String name, String pass) throws Exception {
        // 对密码加盐加密
        String securcePass = MD5Utils.formPassToDBPass(pass);

        Connection connection = DatasScource.getConnection();
        String sql = "select id,name,pass from account where name=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, name);
        ResultSet resultSet = ps.executeQuery();
        connection.close(); // 连接关闭

        if (resultSet.next()) {
            String passInDB = resultSet.getString("pass");
            if (passInDB.equals(securcePass)) {
                return true;  // 密码相同返回true
            }
        }
        return false;  //没有查到数据 或者密码不对 返回false
    }
}
