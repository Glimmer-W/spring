<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<html>
<head>
    <title>入库记录管理</title>
</head>
<body>
<h3><a href="/">返回主页</a></h3>
<h2>入库记录</h2>
<h2><a href="/record/editRecord">新增入库</a></h2>
    <table>
        <thead>
            <td>编号</td>
            <td>公司名称</td>
            <td>公司建账日期</td>
            <td>外勤</td>
            <td>会计</td>
            <td>入库时间</td>
            <td>入库数量</td>
        </thead>
        <tbody>
            <c:forEach items="${recordList}" var="record">
                <tr>
                    <td>${record.id}</td>
                    <td>${record.companyName}</td>
                    <td>${record.buildDate}</td>
                    <td>${record.outerName}</td>
                    <td>${record.accountantName}</td>
                    <td>${record.createDate}</td>
                    <td>${record.number}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
