<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
    <!-- 表单提交到welcome.jsp -->
    <form action="welcome.jsp" method="post">
        姓名: <input type="text" name="username" required><br>
        密码: <input type="password" name="password" required><br>
        <input type="submit" value="提交">
        <input type="reset" value="清除">
    </form>
</body>
</html>

