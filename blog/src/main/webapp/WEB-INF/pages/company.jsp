<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<html>
<head>
    <title>公司信息</title>
</head>
<body>
<h3><a href="/">返回主页</a></h3>
<h2>公司信息</h2>
<h2><a href="/company/editCompany">添加公司</a></h2>
    <table>
        <thead>
            <td>公司编号</td>
            <td>公司名称</td>
            <td>建账日期</td>
        </thead>
        <tbody>
            <c:forEach items="${companyList}" var="company">
                <tr>
                    <td>${company.id}</td>
                    <td>${company.name}</td>
                    <td>${company.buildAccountDate}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
