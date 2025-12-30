package cn.edu.sdju.soft;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "123456";
    private static final int REMEMBER_DAYS = 3 * 24 * 60 * 60;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doPost(request, response); 
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String username = null;
        String password = null;
        Cookie[] cookies = request.getCookies();
        
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("remember_username".equals(cookie.getName())) {
                    username = cookie.getValue(); // 读取存储用户名的Cookie
                }
                if ("remember_password".equals(cookie.getName())) {
                    password = cookie.getValue(); // 读取存储密码的Cookie
                }
            }
        }
        
        if (username == null || password == null) {
            username = request.getParameter("username");
            password = request.getParameter("password");
        }
        
        if (VALID_USERNAME.equals(username) && VALID_PASSWORD.equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("loginUser", username); // 存储登录用户
            session.setAttribute("loginPassword", password); 
            session.setMaxInactiveInterval(3600); // Session有效期：1小时（无操作自动失效）
            
            String remember = request.getParameter("remember"); // 对应login.jsp的复选框name
            if ("on".equals(remember)) { // 复选框勾选时，参数值为"on"
                Cookie userCookie = new Cookie("remember_username", username);
                userCookie.setMaxAge(REMEMBER_DAYS); // 有效期3天
                userCookie.setPath(request.getContextPath()); // Cookie生效路径（整个项目）
                Cookie pwdCookie = new Cookie("remember_password", password);
                pwdCookie.setMaxAge(REMEMBER_DAYS);
                pwdCookie.setPath(request.getContextPath());
                // 向客户端发送Cookie
                response.addCookie(userCookie);
                response.addCookie(pwdCookie);
            }
            
            response.sendRedirect(request.getContextPath() + "/soft18/welcome.jsp");
        } else {
            response.sendRedirect(request.getContextPath() + "/soft18/login.jsp?error=1");
        }
    }
}
