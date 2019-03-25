package com.neuedu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 当前的类，是一个普通的类，继承HttpServlet类，生成了servlet类
 * HttpServlet所在包 javax.servlet.http.HttpServlet;
 * 提交模式：get post put delete head等
 *        常用的get，post
 *  处理：    doGet，doPost
 *  管理处理：service
 *
 *
 */
@WebServlet("/login")
public class MyServlet01 extends HttpServlet {
    /**
     * 两种处理方式，实现一种处理
     * 要处理的有两个：1：请求---HttpServletRequest对象来完成
     *                 2：响应-- HttpServletResponse对象来完成
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // HttpServletRequest方法：getParameter：形参：接受的name的value值；返回类型：String
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        /*System.out.println(username+"   "+password);*/
        // 如果两个值中一个为null或者都为null，响应：登录不成功，否则，成功
        //HttpServletResponse
        /**
         * 1: 文件内容的类型：setContentType
         * 2: 字符编码：setCharacterEncoding
         * 3：通过resp.getWriter方法得到PrintWriter对象
         *     out.print进行输出的时候，
         *     如果输出内容包含html标签，直接使用标签应用
         */
         resp.setContentType("text/html;charset=utf-8");//文件类型
         resp.setCharacterEncoding("utf-8");//设置文件的字符编码

        PrintWriter out=resp.getWriter();
        out.print("<html>");
        out.print("<head>");

        out.print("</head>");
        out.print("<body>");
         if(username!=null&& password!=null&&!"".equals(username)&&!"".equals(password)) {
             out.print("<h1>登录成功："+username+"</h1>");
         }else{
             out.print("<h1>登录失败</h1>");
         }
        out.print("</body>");
        out.print("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
