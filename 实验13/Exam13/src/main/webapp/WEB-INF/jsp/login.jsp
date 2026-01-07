<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
    <h2>登录页面</h2>
    <p style="color:red;">${msg}</p>
    <form action="login" method="post">
        姓名: <input type="text" name="username"><br>
        密码: <input type="password" name="password"><br>
        <input type="submit" value="提交">
        <input type="reset" value="清除">
    </form>
</body>
</html>