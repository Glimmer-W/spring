<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<html>
<head>
    <title>用户信息</title>
</head>
<body>
<h2>用户信息</h2>
<h3><a href="/">返回主页</a></h3>
<h2><a href="/user/editUser">添加用户</a></h2>
    <table>
        <thead>
            <td>序号</td>
            <td>姓名</td>
        </thead>
        <tbody>
            <c:forEach items="${userList}" var="user">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
