<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/1
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.*,com.neuedu.entity.User" %>
<html>
<head>
    <title>头部</title>
    <link rel="stylesheet" type="text/css" href="css/lay.css">
</head>
<body>
<div class="lay_top">
    电商平台管理系统
    <div>
        <% User user=((User)session.getAttribute("user"));
            if(user==null){
                out.print("未登录");
            }else{
                out.print(user.getUname());
            }


        %>
        </div>
    退出
</div>
</body>
</html>
