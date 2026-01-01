package cn.edu.sdju.soft.emp.dao;

public interface UserDao {
    boolean checkNameAndPass(String name, String pass) throws Exception;
}
