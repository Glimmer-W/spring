<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>编辑公司信息</title>
</head>
<body>
    <h2>编辑公司信息</h2>
    <form action="/company/saveCompany" method="post">
        <p>公司编号：<input type="text" name="id"></p>
        <p>公司名称：<input type="text" name="name"></p>
        <p>公司建账日期：<input type="text" name="buildAccountDate"></p>
        <input type="submit" value="提交">
    </form>
</body>
</html>
