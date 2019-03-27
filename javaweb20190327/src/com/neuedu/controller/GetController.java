package com.neuedu.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getlogin")
public class GetController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*req.setCharacterEncoding("utf-8");*/
        String username= req.getParameter("username");
        String password=req.getParameter("password");
        System.out.println(username+"  "+password);

        /*resp.setContentType("text/hmtl;utf-8");
        resp.setCharacterEncoding("utf-8");*/
        resp.getWriter().print(username);
    }
}
