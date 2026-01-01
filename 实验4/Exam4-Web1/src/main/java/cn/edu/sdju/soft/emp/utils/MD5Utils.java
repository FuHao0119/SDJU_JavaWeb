package cn.edu.sdju.soft.emp.utils;

import cn.edu.sdju.soft.emp.dao.impl.EmpDaoImpl;
import cn.hutool.Hutool;
import cn.hutool.crypto.SecureUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MD5Utils {

    private static final String salt = "1u2v3w4x5y6z";

    public static String formPassToDBPass(String str) {
        // 加盐
        String saltedPass = salt.charAt(0)+salt.charAt(4)+str+salt.charAt(1)+salt.charAt(3);
        // 加密
        String securePass = SecureUtil.md5(saltedPass);
        return securePass;
    }

    public static void main(String[] args) throws Exception {
        String name = "abc";
        String pass = "abcd";
        String passwordInDB = MD5Utils.formPassToDBPass(pass);

        String sql = "insert into account (name,pass) values (?,?)";
        Connection connection = DatasScource.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, passwordInDB);
        ps.execute();
    }
}
