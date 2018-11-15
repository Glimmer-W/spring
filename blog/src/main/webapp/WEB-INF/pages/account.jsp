<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>用户信息</title>
</head>
<body>
    <h3><a href="/">返回主页</a></h3>
    <h2>用户信息</h2>
    <p>姓名：${user.name}</p>
    <p>用户名：${user.userName}</p>
    <p>密码：${user.password}</p>
    <p>头像：<a href="/file/getFile?fileName=${user.headPhotoImageName}"><img src="/file/getFile?fileName=${user.headPhotoImageName}"></a></p>
</body>
</html>
