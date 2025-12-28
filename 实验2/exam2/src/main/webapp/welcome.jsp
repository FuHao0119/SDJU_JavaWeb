<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录验证</title>
</head>
<body>
    <%
        // 1. 解决中文乱码
        request.setCharacterEncoding("UTF-8");
        // 2. 获取登录参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // 3. 验证账号密码
        if ("admin".equals(username) && "abc".equals(password)) {
            // 验证成功：存入session，跳转到content.jsp
            session.setAttribute("loginUser", username);
            response.setHeader("refresh", "5;url=content.jsp");
            out.print("登录成功！5秒后跳转到内容页，若未跳转请点击<a href='content.jsp'>此链接</a>");
        } else {
            // 验证失败：跳回login.jsp
            response.setHeader("refresh", "10;url=login.jsp");
            out.print("您的用户名或密码不正确！10秒后跳回登录页，若未跳转请点击<a href='login.jsp'>此链接</a>");
        }
    %>
</body>
</html>
