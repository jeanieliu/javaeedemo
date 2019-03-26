package com.neuedu.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/mycontext02")
public class MyServlet05 extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 1：生成ServletContext对象
         *     1)this.getServletContext();
         */
        ServletContext context=this.getServletContext();
        String charset= context.getInitParameter("charset");

        resp.setContentType("text/html;charset=utf-8");
        System.out.println(context.getAttribute("contexttype"));
        resp.setCharacterEncoding(charset);
        resp.getWriter().print(charset);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
