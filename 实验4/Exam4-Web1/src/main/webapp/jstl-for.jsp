<%--
  Created by IntelliJ IDEA.
  User: fuhao
  Date: 2025/10/16
  Time: 13:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    String[] fruits = {"apple","banana","pear"};
    session.setAttribute("fruits",fruits);
%>

<c:forEach var="f" items="${fruits}" varStatus="order">
    <c:out value="${order.index} : ${order.count} : ${f}"></c:out> <br>
</c:forEach>


</body>
</html>
