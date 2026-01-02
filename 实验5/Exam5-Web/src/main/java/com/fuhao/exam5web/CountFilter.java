package com.fuhao.exam5web;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;

import java.io.IOException;

@WebFilter(
        filterName = "myFilter",
        urlPatterns = {"/counter.jsp"},  // 确保与访问的文件名一致
        initParams = {
                @WebInitParam(name = "count", value = "0"),
        }
)
public class CountFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("计数器 Filter 初始化");
        String configValue = filterConfig.getInitParameter("count");
        int count = Integer.parseInt(configValue);
        ServletContext servletContext = filterConfig.getServletContext();
        servletContext.setAttribute("count", count);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("计数器 Filter 执行");

        ServletContext servletContext = servletRequest.getServletContext();
        Object count = servletContext.getAttribute("count");
        int newCount = (Integer) count + 1;
        servletContext.setAttribute("count", newCount);

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("计数器 Filter 销毁");
    }
}
