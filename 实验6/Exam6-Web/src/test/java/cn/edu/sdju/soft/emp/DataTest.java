package cn.edu.sdju.soft.emp;

import cn.edu.sdju.soft.emp.bean.Emp;
import cn.edu.sdju.soft.emp.dao.EmpDao;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Properties;

public class DataTest {

    @Test
    public void test2(){
        List<Emp> all = new EmpDao() {
            @Override
            public List<Emp> getAll() {
                return List.of();
            }
        }.getAll();
    }


    @Test
    public void test1() throws Exception {
        InputStream input = DataTest.class.getClassLoader().getResourceAsStream("druid.properties");
        Properties prop = new Properties();
        prop.load(input);
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        Emp emp1 = new Emp(1, "libai", "M", "hr");
        Emp emp2 = new Emp(2, "Dufu", "F", "finance");
        Emp emp3 = new Emp(3, "Baijuyi", "M", "trade");
        Emp emp4 = new Emp(4, "Liuzongyuan", "F", "trade");

        insertEmployees(dataSource, emp1, emp2, emp3, emp4);

        System.out.println("数据插入成功！");

    }

    public static void insertEmployees(DataSource dataSource, Emp... employees) {
        String sql = "INSERT INTO emp (id, ename, esex, dept) VALUES (?, ?, ?, ?)";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            for (Emp emp : employees) {
                pstmt.setInt(1, emp.getId());
                pstmt.setString(2, emp.getName());
                pstmt.setString(3, emp.getSex());
                pstmt.setString(4, emp.getDept());
                pstmt.addBatch();
            }

            int[] results = pstmt.executeBatch(); // 执行批处理
            System.out.println("成功插入 " + results.length + " 条记录");

        } catch (Exception e) {
            throw new RuntimeException("插入员工数据失败", e);
        }
    }
}
