<%--
  Created by IntelliJ IDEA.
  User: fuhao
  Date: 2025/10/16
  Time: 12:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="param.jsp" method="POST">
    <input type="text" name="uname"/>
    <input type="submit" value="SAVE">
</form>

${param.get("uname")}

<% request.getParameter("uname"); %>

${cookie.get("cookie_name").name}
${cookie.get("cookie_name").value}

</body>
</html>
