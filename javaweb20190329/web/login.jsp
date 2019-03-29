<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/29
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员登录</title>
</head>
<body>
  <form action="login.user" method="post">
      用户名:<input type="text" name="username">
      <br>
      密码：<input type="password" name="password">
      <br>
      <input type="submit" value="登录">
  </form>
</body>
</html>
