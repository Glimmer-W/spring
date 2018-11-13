<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
</head>
<body>
    <h2>注册</h2>
    <form action="/register/" method="post" enctype="multipart/form-data">
        <p>姓名：<input type="text" name="name"></p>
        <p>用户名：<input type="text" name="userName"></p>
        <p>密码：<input type="password" name="password"></p>
        <p>头像：<input type="file" name="headPhoto"></p>
        <input type="submit" value="提交">
    </form>
</body>
</html>
