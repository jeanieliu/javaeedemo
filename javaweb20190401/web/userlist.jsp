<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/28
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.*,com.neuedu.entity.User" %>
<html>
<head>
    <title>显示用户信息</title>
</head>
<body>

<div class="laycontent">
    <%@include file="lay/top.jsp"%>
    <div class="lay_middle">
        <%@include file="lay/left.jsp"%>
        <div class="lay_right">

            <a href="useradd.jsp"><input type="button" value="添加"></a>
            <table>
                <caption>显示用户信息</caption>
                <tr>
                    <th>用户名</th>
                    <th>电话号码</th>
                    <th>住址</th>
                    <th>操作</th>
                </tr>
                <%
                    List<User> userList=(List<User>)request.getAttribute("users");
                    for(User u:userList) {
                        out.print("<tr >"+
                                "<td >" +u.getUname()+"</td >"+
                                "<td >" +u.getTelephone()+"</td >"+
                                "<td >" + u.getAddress()+"</td >"+
                                "<td > <a href='delete.user?id="+u.getUid()+"'>删除</a> &nbsp;&nbsp;&nbsp;<a href='find.user?id="+u.getUid()+"'>修改</a></td ></tr >");
                    }
                %>
            </table>

        </div>

    </div>
    <%@include file="lay/foot.jsp"%>
</div>


</body>

</html>
