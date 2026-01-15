package cn.edu.sdju.soft.exam14.controller;


import cn.edu.sdju.soft.exam14.entity.User;
import cn.edu.sdju.soft.exam14.entity.UserDTO;
import cn.edu.sdju.soft.exam14.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public String addUser(@RequestBody UserDTO userDTO) throws Exception {
        log.info("添加用户： " +  userDTO.toString());
        userService.addUser(userDTO);
        return "success";
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Integer id) throws Exception {
        log.info("查询id为: " + id + "的用户");
        try {
            return userService.getUser(id);
        }catch (Exception e){
            throw new Exception("接口调用失败");
        }
    }

    @GetMapping("/list")
    public List<User> getAllUser() throws Exception {
        log.info("查询所有用户");
        try {
            return userService.getAllUser();
        }catch (Exception e){
            throw new Exception("接口调用失败");
        }
    }


    @PutMapping("/update")
    public void updateUser(@RequestBody User user) throws Exception {
        log.info("更新用户信息: " +  user.toString());
        userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Integer id) throws Exception {
        log.info("删除id为: " + id + "的用户");
        try {
            userService.deleteUser(id);
        }catch (Exception e){
            throw new Exception("接口调用失败");
        }
        return "success";
    }

}
