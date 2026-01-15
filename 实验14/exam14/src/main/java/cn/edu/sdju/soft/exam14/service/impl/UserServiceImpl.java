package cn.edu.sdju.soft.exam14.service.impl;

import cn.edu.sdju.soft.exam14.entity.User;
import cn.edu.sdju.soft.exam14.entity.UserDTO;
import cn.edu.sdju.soft.exam14.mapper.UserMapper;
import cn.edu.sdju.soft.exam14.service.UserService;
import cn.edu.sdju.soft.exam14.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 添加用户业务逻辑
     * @param userDTO
     */
    @Override
    @Transactional
    public void addUser(UserDTO userDTO) throws Exception {
        if(!ValidationUtils.isAgeValid(userDTO.getAge()) ||
                !ValidationUtils.isEmailValid(userDTO.getEmail()) ||
                !ValidationUtils.isUsernameValid(userDTO.getUsername())) {
            throw new Exception("参数错误");
        }
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setAge(userDTO.getAge());
        user.setEmail(userDTO.getEmail());
        user.setGender(userDTO.getGender());
        LocalDateTime now = LocalDateTime.now();
        user.setCreateTime(now);
        user.setUpdateTime(now);
        try {
            userMapper.addUser(user);
        } catch (Exception e) {
            throw new Exception("数据库异常");
        }

    }

    /**
     * 根据id查询用户业务逻辑
     * @param id
     * @return
     */
    @Override
    public User getUser(Integer id) throws Exception {
        try {
            return userMapper.getUserById(id);
        } catch (Exception e) {
            throw new Exception("数据库异常");
        }
    }


    /**
     * 查询所有用户业务逻辑
     * @return
     */
    @Override
    public List<User> getAllUser() throws Exception {
        try {
            return userMapper.selectAll();
        } catch (Exception e) {
            throw new Exception("数据库异常");
        }
    }


    /**
     * 更新用户信息业务逻辑
     * @param user
     */
    @Override
    @Transactional
    public void updateUser(User user) throws Exception {
        if(user.getAge() != null && !ValidationUtils.isAgeValid(user.getAge()) ||
                user.getEmail() != null && !ValidationUtils.isEmailValid(user.getEmail()) ||
                user.getUsername() != null && !ValidationUtils.isUsernameValid(user.getUsername())) {
            throw new Exception("参数错误");
        }
        user.setUpdateTime(LocalDateTime.now());
        try {
            userMapper.update(user);
        } catch (Exception e) {
            throw new Exception("数据库异常");
        }
    }


    /**
     * 删除用户业务逻辑
     * @param id
     */
    @Override
    public void deleteUser(Integer id) throws Exception {
        try {
            userMapper.deleteById(id);
        } catch (Exception e) {
            throw new Exception("数据库异常");
        }
    }
}
