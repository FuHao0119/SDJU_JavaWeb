<%@ page import="com.fuhao.exam5web.CounterListener" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>网站访问统计</title>
</head>
<body>
<h2>网站访问统计</h2>

<div>
    <p><strong>总访问次数：</strong>
        <%= application.getAttribute("count") %>
    </p>

    <p><strong>当前在线用户数：</strong>
        <%= CounterListener.count %>
    </p>

    <p><strong>服务器信息：</strong>
        <%= application.getServerInfo() %>
    </p>

    <p><strong>当前Session ID：</strong>
        <%= session.getId() %>
    </p>
</div>

<br>
</body>
</html>
