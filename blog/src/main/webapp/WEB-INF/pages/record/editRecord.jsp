<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>编辑入库记录</title>
</head>
<body>
    <h2>编辑入库记录</h2>
    <form action="/record/save" method="post">
        <p>id：<input type="text" name="id"></p>
        <p>
            公司：
            <select name="companyId" >
                <c:forEach items="${companyList}" var="company">
                    <option value="${company.id}">${company.name}</option>
                </c:forEach>
            </select>
        </p>
        <p>
            外勤人员：
            <select name="outerId" >
                <c:forEach items="${userList}" var="user">
                    <option value="${user.id}">${user.name}</option>
                </c:forEach>
            </select>
        </p>
        <p>
            会计人员：
            <select name="accountantId" >
                <c:forEach items="${userList}" var="user">
                    <option value="${user.id}">${user.name}</option>
                </c:forEach>
            </select>
        </p>
        <p>入库日期：<input type="text" name="createDate"></p>
        <p>入库数量：<input type="text" name="number"></p>
        <input type="submit" value="提交">
    </form>
</body>
</html>
