<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/26
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录之后的界面</title>
</head>
<body>
<%--
    jsp中相当于一个servlet：
    给定内置对象：request，response，out(相当于response对象的调用的getWriter方法生成 PrintWriter对象)
    1:使用request的getAttribute接收数据
       参数：setAttribute设置的第一个参数
       返回值：Object
       如果要接受其他类型对象，进行强制转换
--%>
<%
  String username=(String) request.getAttribute("name");
   out.print("<h1 style='color:red'>"+username+"</h1>");
%>
</body>
</html>
