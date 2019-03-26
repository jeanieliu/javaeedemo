<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/26
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>全局变量</title>
</head>
<body>
<%--
 jsp中application相当于servlet中ServletContext对象
--%>
 <%
   out.print(application.getInitParameter("charset"));
   out.print(application.getAttribute("contexttype"));
 %>
</body>
</html>
