package cn.edu.sdju.soft.exam14.service;

import cn.edu.sdju.soft.exam14.entity.User;
import cn.edu.sdju.soft.exam14.entity.UserDTO;
import java.util.List;

public interface UserService {
    void addUser(UserDTO userDTO) throws Exception;
    User getUser(Integer id) throws Exception;
    List<User> getAllUser() throws Exception;
    void updateUser(User user) throws Exception;
    void deleteUser(Integer id) throws Exception;
}
