<%--
  Created by IntelliJ IDEA.
  User: fuhao
  Date: 2025/10/16
  Time: 12:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    Cookie cookie = new Cookie("sdju","pudong");
    response.addCookie(cookie);
%>

Cookie sdju的句柄: ${cookie.get("sdju")} <br>
Cookie sdju的名字: ${cookie.get("sdju").name} <br>
Cookie sdju的值: ${cookie.get("sdju").value} <br>

</body>
</html>
