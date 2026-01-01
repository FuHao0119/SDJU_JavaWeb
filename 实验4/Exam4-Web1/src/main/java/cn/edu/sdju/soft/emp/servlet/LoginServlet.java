package cn.edu.sdju.soft.emp.servlet;

import cn.edu.sdju.soft.emp.dao.UserDao;
import cn.edu.sdju.soft.emp.dao.impl.UserDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String name = req.getParameter("name");
        String pass = req.getParameter("pass");
        System.out.println("接收到用户名: "+name);
        System.out.println("接收到密码 : "+pass);
        UserDao userDao = new UserDaoImpl();
        try {
            boolean checked = userDao.checkNameAndPass(name, pass);
            if (checked) {
                System.out.println("密码正确，设置cookie并跳转到empList页面");
                String token = name;
                Cookie userCookie = new Cookie("userToken", token);
                userCookie.setMaxAge(24 * 60 * 60);
                userCookie.setPath("/");
                resp.addCookie(userCookie);
                resp.sendRedirect("/ListEmpServlet");
            }else {
                System.out.println("密码错误，跳转到登陆页面");
                resp.sendRedirect("/login.jsp");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
