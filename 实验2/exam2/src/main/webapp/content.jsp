<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>内容页面（99乘法表）</title>
    <style>
        span { display: inline-block; width: 80px; }
    </style>
</head>
<body>
    <%
        // 验证是否登录（避免直接访问）
        String loginUser = (String) session.getAttribute("loginUser");
        if (loginUser == null) {
            // 未登录：强制跳回登录页
            response.sendRedirect("login.jsp");
            return; // 终止后续代码执行
        }
    %>
    <!-- 显示登录用户名和99乘法表 -->
    <h3>欢迎您，<%= loginUser %>！以下是99乘法表：</h3>
    <%
        for (int i = 1; i <= 9; i++) { // 行数：1-9
            for (int j = 1; j <= i; j++) { // 列数：1-i
                out.print(j + "*" + i + "=" + (i*j));
                out.print("<span></span>"); // 用span控制宽度，使排版整齐
            }
            out.print("<br>"); // 换行
        }
    %>
</body>
</html>
