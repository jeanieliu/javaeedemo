package com.neuedu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login02")
public class LoginServlet02  extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(username!=null&& password!=null&&!"".equals(username)&&!"".equals(password)){
            /**
             * 重定向：重新启动一个页面
             * response实现重定向
             *    调用：resp.sendRedirect()
             *      参数：重定向的页面
             */
            resp.sendRedirect("result.html");

        }else{
            resp.sendRedirect("login.html");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
