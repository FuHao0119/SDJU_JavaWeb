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
<c:set var="page" scope="session" value="12"></c:set>

<c:if test="${page<200}">
    共<c:out value="${page}"></c:out>页
</c:if>

</body>
</html>
