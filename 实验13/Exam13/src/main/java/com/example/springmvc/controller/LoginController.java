package com.example.springmvc.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.springmvc.bean.User;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public ModelAndView login(User user) {
        System.out.println("Username: " + user.getUsername());
        System.out.println("Password: " + user.getPassword());

        ModelAndView mav = new ModelAndView();
        if (user.getUsername().isEmpty() || user.getPassword().isEmpty()) {
            mav.setViewName("login");
            mav.addObject("msg", "用户名或密码不能为空！");
            return mav;
        }
        mav.setViewName("welcome");
        mav.addObject("user", user);
        return mav;
    }

    @PostMapping("/login/json")
    @ResponseBody
    public Map<String, Object> loginByJson(@RequestBody User user) {
        System.out.println("Login with JSON:");
        System.out.println("Username: " + user.getUsername());
        System.out.println("Password: " + user.getPassword());
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("user", user);
        return result;
    }
}
