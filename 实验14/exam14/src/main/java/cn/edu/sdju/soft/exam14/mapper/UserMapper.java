package cn.edu.sdju.soft.exam14.mapper;

import cn.edu.sdju.soft.exam14.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    void addUser(User user);
    User getUserById(Integer id);
    List<User> selectAll();
    void update(User user);
    void deleteById(Integer id);
}
