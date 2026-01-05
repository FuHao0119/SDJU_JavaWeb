package cn.edu.sdju.soft.exp.test;

import cn.edu.sdju.soft.exp.bean.Customer;
import cn.edu.sdju.soft.exp.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CustomerTest {

    private static final Logger logger = LoggerFactory.getLogger(CustomerTest.class);
    SqlSession sqlSession = MybatisUtil.getSession();

    // 测试插入一条数据
    @Test
    public void insertOne(){
        Customer customer = new Customer();
        customer.setId(3);
        customer.setUsername("admin3");
        customer.setJobs("engineer3");
        customer.setPhone("phone3");
        try {
            sqlSession.insert("insertCustomer", customer);
            sqlSession.commit();
            sqlSession.close();
            logger.info("insert success: " + customer);
        }catch (Exception e){
            logger.error("insert error: " + e.getMessage());
        }
    }

    // 查看一条数据
    @Test
    public void selectOne(){
        try{
            Customer customer = (Customer) sqlSession.selectOne("selectCustomer", 3);
            logger.info("selectOne success: " + customer);
        }catch (Exception e){
            logger.error("select error: " + e.getMessage());
        }
    }

    // 测试查看所有数据
    @Test
    public void selectAll(){
        try{
            List<Object> customers = sqlSession.selectList("selectAll");
            logger.info("selectAll success");
            for(Object customer : customers){
                System.out.println((Customer)customer);
            }
        }catch (Exception e){
            logger.error("selectAll error: " + e.getMessage());
        }
    }

    // 测试修改一条数据
    @Test
    public void updateOne(){
        try{
            Customer newCustomer = new Customer();
            newCustomer.setId(2);
            newCustomer.setUsername("admin1");
            newCustomer.setJobs("engineer1");
            newCustomer.setPhone("18943321234");
            sqlSession.update("updateCustomer", newCustomer);
            logger.info("update success: " + newCustomer);
        }catch (Exception e){
            logger.error("select error: " + e.getMessage());
        }
    }

    // 测试删除数据
    @Test
    public void deleteOne(){
        try{
            sqlSession.delete("deleteCustomer", 3);
            logger.info("delete success: ");
        } catch (Exception e){
            logger.error("delete error: " + e.getMessage());
        }
    }
}
