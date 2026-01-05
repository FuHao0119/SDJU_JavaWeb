package cn.edu.sdju.soft.exp.dao;

import cn.edu.sdju.soft.exp.bean.Customer;

import java.util.List;

public interface CustomerDao {
    Customer getCustomer(int id); // 根据id查询
    List<Customer> getCustomers(); // 返回列表
    boolean add(Customer customer); // 添加
    boolean update(Customer customer);  // 修改
    boolean delete(int id); // 删除
}
