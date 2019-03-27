package com.neuedu.controller;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/sessionlogin")
public class SessionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String username=req.getParameter("username");
       String password=req.getParameter("password");
        /**
         * 在网站中的所有的页面中显示用户名
         *    Session
         *    1:得到HttpSession对象
         *       通过request对象的getSession方法
         *    2：给session对象赋值：判断用户名和密码没有问题的时候在赋值
         *       setAttribute赋值
         */
      HttpSession session=  req.getSession();

       if(username!=null&& password!=null&&!"".equals(password) &&!"".equals(username)){
           session.setAttribute("username",username);
           resp.sendRedirect("main.jsp");
       }else{
           resp.sendRedirect("login.html");
       }
    }
}
