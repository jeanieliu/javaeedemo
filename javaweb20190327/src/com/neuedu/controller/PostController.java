package com.neuedu.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/postlogin")
public class PostController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //req.setCharacterEncoding("utf-8");/*请求时出现的乱码*/
        String username= req.getParameter("username");
        String password=req.getParameter("password");
        /*System.out.println(username+"  "+password);*/
        /*响应时，处理乱码：
        * 1：内容类型
        * 2：字符编码
        * */
        /*resp.setContentType("text/hmtl;utf-8");
        resp.setCharacterEncoding("utf-8");*/
        resp.getWriter().print(username);
    }
}
