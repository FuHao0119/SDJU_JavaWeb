<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录页</title>
    <style>
        /* 简单样式：居中表单 */
        .login-box {
            width: 300px;
            margin: 100px auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .form-item {
            margin: 15px 0;
        }
        label {
            display: inline-block;
            width: 80px;
        }
        input {
            padding: 5px;
            width: 180px;
        }
        .btn {
            width: 100px;
            margin-left: 80px;
            cursor: pointer;
        }
        .error {
            color: red;
            text-align: center;
            margin: 10px 0;
        }
    </style>
</head>
<body>
    <div class="login-box">
        <h2 style="text-align: center;">用户登录</h2>
        <% if (request.getParameter("error") != null) { %>
            <div class="error">用户名或密码错误，请重新输入！</div>
        <% } %>
 
        <form action="<%= request.getContextPath() %>/LoginServlet" method="post">
            <div class="form-item">
                <label for="username">用户名：</label>
                <input type="text" id="username" name="username" required>
            </div>
            <div class="form-item">
                <label for="password">密码：</label>
                <input type="password" id="password" name="password" required>
            </div>
            <div class="form-item">
                <label>&nbsp;</label> 
                <input type="checkbox" id="remember" name="remember" style="width: 40px;"> 
                <label for="remember" style="width: auto;">3天免登录</label>
            </div>
            <div class="form-item">
                <input type="submit" class="btn" value="提交">
            </div>
        </form>
    </div>
</body>
</html>
