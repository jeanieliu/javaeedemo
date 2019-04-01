<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/1
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.*,com.neuedu.entity.User" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>头部</title>
    <link rel="stylesheet" type="text/css" href="css/lay.css">
</head>
<body>
<%--<%
    pageContext.setAttribute("page1","page");
  pageContext.getSession().setAttribute("kk","kk");
  /*session.setAttribute("kk","kk");*/
  out.print(pageContext.getAttribute("page1"));
%>--%>
<div class="lay_top">

    电商平台管理系统
    <div>
        <%--<% User user=((User)session.getAttribute("user"));
            if(user==null){
                out.print("未登录");
            }else{
                out.print(user.getUname());
            }


        %>--%>
        <%--
          选择控制：c:if
             只有一个结果，为true进行处理

             属性：test
        --%>
       <%-- <c:if test="${user==null}">
            <c:out value="未登录"/>
        </c:if>

            <c:if test="${user!=null}">
               <c:out value="${user.uname}"/>
            </c:if>--%>
        ${user!=null?user.uname:"未登录"}

        <%--<c:forTokens items="123-456-678-229" delims="-" var="str">
            <c:out value="${str}"/>
        </c:forTokens>--%>
        </div>
    退出
</div>
</body>
</html>
