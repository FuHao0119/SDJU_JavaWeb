package cn.edu.sdju.soft.emp.dao;

import cn.edu.sdju.soft.emp.bean.Emp;
import java.util.List;

public interface EmpDao {
    List<Emp> findAll() throws Exception;
}
