<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>投票结果</title>
    <style>
        .result-box {
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
        .result-title {
            font-size: 18px;
            margin: 20px 0;
        }
        .result-item {
            margin: 12px 0;
            display: flex;
            align-items: center;
        }
        .option-name {
            width: 80px;
            text-align: right;
            margin-right: 10px;
        }
        .bar-container {
            flex: 1;
            height: 15px;
            border: 1px solid #ccc;
            overflow: hidden;
        }
        .bar {
            height: 100%;
        }
        .rate {
            margin-left: 10px;
            width: 50px;
            text-align: right;
        }
        .back-btn {
            display: inline-block;
            margin-top: 20px;
            padding: 6px 20px;
            background: #f5f5f5;
            border: 1px solid #ccc;
            border-radius: 3px;
            color: #333;
            text-decoration: none;
        }
        .back-btn:hover {
            background: #eee;
        }
    </style>
</head>
<body>
    <div class="result-box">
        <% 
            String loginUser = (String) session.getAttribute("loginUser");
            if (loginUser == null) {
                response.sendRedirect(request.getContextPath() + "/login.jsp");
                return;
            }
            int totalVotes = cn.edu.sdju.soft.VoteUtil.getTotalVotes();
        %>
        <div class="user-info">
            你好, <%= loginUser %>, 欢迎回来！
            <a href="<%= request.getContextPath() %>/LogoutServlet" class="logout">退出</a>
        </div>
        
        <!-- 2. 显示投票结果 -->
        <div class="result-title">投票结果（总票数：<%= totalVotes %>）：</div>
        <% 
            String[] options = cn.edu.sdju.soft.VoteUtil.OPTIONS;
            for (String option : options) {
                int count = cn.edu.sdju.soft.VoteUtil.getVoteCount(option);
                int rate = cn.edu.sdju.soft.VoteUtil.getVoteRate(option); // 百分比
        %>
            <div class="result-item">
                <div class="option-name"><%= option %>：</div>
                <div class="bar-container">
                    <img src="<%= request.getContextPath() %>/img/bar.jpg" 
                         class="bar" 
                         width="<%= rate %>% " 
                         alt="<%= option %>得票率">
                </div>
                <div class="rate"><%= rate %>%（<%= count %>票）</div>
            </div>
        <% } %>
        <a href="<%= request.getContextPath() %>/soft18/welcome.jsp" class="back-btn">返回</a>
    </div>
</body>
</html>
