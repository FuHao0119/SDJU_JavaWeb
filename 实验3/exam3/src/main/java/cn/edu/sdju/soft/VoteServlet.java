package cn.edu.sdju.soft;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/VoteServlet")
public class VoteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8"); // 解析请求参数的编码（表单提交的中文）
        response.setContentType("text/html;charset=UTF-8"); // 响应页面的编码
        HttpSession session = request.getSession();
        String loginUser = (String) session.getAttribute("loginUser");
        if (loginUser == null) {
            response.sendRedirect(request.getContextPath() + "/soft18/login.jsp");
            return;
        }
        
        String[] selectedOptions = request.getParameterValues("voteOption");
        for (String option : selectedOptions) {
            System.out.println("用户选中的投票选项：" + option);
        }
        VoteUtil.addVote(selectedOptions);
        response.sendRedirect(request.getContextPath() + "/soft18/votingResults.jsp");
    }
}
