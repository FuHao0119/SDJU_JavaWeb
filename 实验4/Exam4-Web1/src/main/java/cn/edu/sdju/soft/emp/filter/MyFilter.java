package cn.edu.sdju.soft.emp.filter;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebFilter(
        filterName = "myFilter",
        urlPatterns = {"/ListEmpServlet"}
)
public class MyFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        Cookie[] cookies = req.getCookies();
        boolean isLogin = false;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("userToken")) {
                    isLogin = true;
                    break;
                }
            }
        }

        if (isLogin) {
            filterChain.doFilter(req, res);
        } else {
            res.sendRedirect(req.getContextPath() + "/login.jsp");
        }
    }

}
