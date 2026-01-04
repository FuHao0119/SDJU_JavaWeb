package cn.edu.sdju.soft.emp.dao;

import cn.edu.sdju.soft.emp.bean.Emp;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface EmpDao {

    @Select("select * from emp")
    List<Emp> getAll();
}
