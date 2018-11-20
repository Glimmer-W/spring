<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>主页</title>
</head>
<body class="loading">
<h2>这是我的主页！</h2>
<%--认证通过后才显示下面的信息--%>
<sec:authorize access="isAuthenticated()">
    <p>
        你好<sec:authentication property="principal.username"/>!
    </p>
</sec:authorize>

<%--没有认证才显示下面的链接--%>
<sec:authorize access="not(isAuthenticated())">
    <p><a href="/login">登录</a></p>
    <p><a href="/register">注册</a></p>
</sec:authorize>

<%--认证通过后才显示下面的链接--%>
<sec:authorize access="isAuthenticated()">
    <p><a href="/logout">退出</a></p>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <p><a href="/company/manage">公司管理</a></p>
        <p><a href="/user/userManage">用户管理</a></p>
    </sec:authorize>
    <sec:authorize access="hasRole('ROLE_USER')">
        <p><a href="/record/recordManage">入库管理</a></p>
    </sec:authorize>
</sec:authorize>
</body>
</html>
