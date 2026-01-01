<%--
  Created by IntelliJ IDEA.
  User: fuhao
  Date: 2025/10/30
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
</head>
<body>
输入用户名密码: <br>
<form action="/LoginServlet" method="post">
    <input type="text" name="name"> <br>
    <input type="text" name="pass"> <br>
    <button type="submit">登录</button>
</form>
</body>
</html>
