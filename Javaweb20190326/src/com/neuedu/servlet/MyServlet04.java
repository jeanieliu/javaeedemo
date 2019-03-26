package com.neuedu.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/mycontext01")
public class MyServlet04  extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 1：生成ServletContext对象
         *     1)this.getServletContext();
         */
        ServletContext context=this.getServletContext();
        context.setAttribute("contexttype","text/html;charset=utf-8");
       String charset= context.getInitParameter("charset");

        resp.setContentType((String)context.getAttribute("contexttype"));

        resp.setCharacterEncoding(charset);
        resp.getWriter().print(charset);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

}
