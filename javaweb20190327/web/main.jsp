<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/27
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录之后的页面</title>
</head>
<body>
登录之后的页面：<%
      /*内置对象session*/
       out.print(session.getAttribute("username"));
%>
</body>
</html>
