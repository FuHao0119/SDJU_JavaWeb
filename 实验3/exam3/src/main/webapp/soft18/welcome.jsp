<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>欢迎页</title>
    <style>
        .welcome-box {
            width: 500px;
            margin: 50px auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .user-info {
            text-align: right;
            margin-bottom: 20px;
        }
        .logout {
            color: #0066cc;
            text-decoration: none;
            margin-left: 10px;
        }
        .logout:hover {
            text-decoration: underline;
        }
        .vote-title {
            font-size: 18px;
            margin: 20px 0;
        }
        .vote-option {
            margin: 8px 0;
        }
        .vote-btn {
            padding: 6px 20px;
            margin-top: 10px;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <div class="welcome-box">
        <% 
            String loginUser = (String) session.getAttribute("loginUser");
        	  String loginPassword = (String) session.getAttribute("loginPassword");
            if (loginUser == null) { // 未登录或Session失效
                response.sendRedirect(request.getContextPath() + "/login.jsp");
                return;
            }
        %>
        <div class="user-info">
            你好, <%= loginUser %>, 欢迎回来！
          
            <a href="<%= request.getContextPath() %>/LogoutServlet" class="logout">退出</a>
        </div>
        
          <br>
            用户名：<%=loginUser %>
            <br>
            密码：<%=loginPassword %>
        
        
        
        <!-- 2. 投票表单（提交到VoteServlet） -->
        <form action="<%= request.getContextPath() %>/VoteServlet" method="post">
            <div class="vote-title">请为你的爱好投票（可多选）：</div>
            <% 
                String[] options = cn.edu.sdju.soft.VoteUtil.OPTIONS;
                for (String option : options) {
            %>
                <div class="vote-option">
                    <input type="checkbox" name="voteOption" id="opt_<%= option %>" value="<%= option %>">
                    <label for="opt_<%= option %>"><%= option %></label>
                </div>
            <% } %>
            <input type="submit" class="vote-btn" value="投票">
        </form>
    </div>
</body>
</html>
