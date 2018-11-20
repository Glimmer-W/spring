<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>编辑用户信息</title>
</head>
<body>
    <h2>编辑用户信息</h2>
    <form action="/user/save" method="post">
        <p>id：<input type="text" name="id"></p>
        <p>姓名：<input type="text" name="name"></p>
        <input type="submit" value="提交">
    </form>
</body>
</html>
