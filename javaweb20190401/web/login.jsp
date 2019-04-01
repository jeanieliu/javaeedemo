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
      用户名:<input type="text" name="username" value="">
      <br>
      密码：<input type="password" name="password" value="">
      <br>
      <input type="checkbox" name="ifsave" value="1">记住用户名和密码
      <br>
      <input type="submit" value="登录">

  </form>
<%--从cookie中取值--%>
     <%
        Cookie[] cookies=request.getCookies();
        if(cookies!=null){
            for(Cookie c:cookies){
                if(c.getName().equals("name")){
                    out.print(c.getValue());
                }
                if(c.getName().equals("password")){
                    out.print(c.getValue());
                }
            }
        }

     %>

</body>
</html>
