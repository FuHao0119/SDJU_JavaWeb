package cn.edu.sdju.soft;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("loginUser");
        session.invalidate(); 
        
        Cookie userCookie = new Cookie("remember_username", "");
        userCookie.setMaxAge(0); // 有效期0：立即删除
        userCookie.setPath(request.getContextPath());
        
        Cookie pwdCookie = new Cookie("remember_password", "");
        pwdCookie.setMaxAge(0);
        pwdCookie.setPath(request.getContextPath());
        response.addCookie(userCookie);
        response.addCookie(pwdCookie);
        response.sendRedirect(request.getContextPath() + "/soft18/login.jsp");
    }
}
