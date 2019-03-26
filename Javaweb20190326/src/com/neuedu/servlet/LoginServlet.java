package com.neuedu.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        /**
         * 1：将当前的数据username传入到main.html
         * 2：显示main.html内容
         */
        //请求转发：将req、resp传入另一个页面，两个页面就应用一样req、resp

        // 1:使用req: req.setAttribute();  用于保存数据
        /**
         *  第一个参数：自定义的---相当于name值：name
         *  第二个参数：真正的value值：username
         */
        req.setAttribute("name",username);

        //2：请求转发
        /**
         * 2.1:生成RequestDispatcher对象
         *     通过req.getRequestDispatcher，同时赋值参数：参数为你要转到网页的路径
         * 2.2 :调用RequestDispatcher对象，forward方法，同时赋值：req、resp
         */
        RequestDispatcher dispatcher= req.getRequestDispatcher("main.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
