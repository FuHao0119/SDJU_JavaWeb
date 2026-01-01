<%--
  Created by IntelliJ IDEA.
  User: fuhao
  Date: 2025/10/23
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        table {
            border-collapse: collapse;
            margin: 20px 0;
            border: 2px solid #333;
        }
        th, td {
            border: 1px solid #666;
            padding: 8px;
            text-align: left;
        }
        .even-row {
            background-color: green;
        }
    </style>
</head>

<body>
Emp List:
<br>
<table>
    <thead>
    <tr>
        <th>No</th>
        <th>Name</th>
        <th>Sex</th>
        <th>Department</th>
    </tr>
    </thead>
    <tbody>
        <c:forEach var="emp" items="${empList}" varStatus="order" >
            <tr class="${order.count%2==0 ? 'even-row' :''}">
                <th>${emp.id}</th>
                <th>${emp.name}</th>
                <th>${emp.sex}</th>
                <th>${emp.dept}</th>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
