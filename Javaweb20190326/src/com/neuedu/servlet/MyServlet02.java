package com.neuedu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * name="myServlet02" ：servlet名
 * urlPatterns = {"/myservlet02","/myservlet03"}：映射的路径
 *loadOnStartup = 1:服务器启动的时候创建并初始化serlvet
 *
 */
@WebServlet(name="myServlet02",urlPatterns = {"/myservlet02","/myservlet03"},
loadOnStartup = 1)
public class MyServlet02 extends HttpServlet{
    /**
     * serlvet，单例模式
     * 声明周期：
     *   1：通过浏览器请求网址的，调用servlet，当servlet没有创建对象时，执行2，否则直接执行3
     *:2：:创建对象并初始化init
     * 3：生成HttpServletRequest对象和HttpServletResponse对象，调用service方法
     *    分配使用的是doGet或者doPost
     * 4：当服务器关闭或者宕机的时候，调用destory方法。
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        System.out.println("创建servlet02并初始化init方法");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().print("测试02");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    public void destroy() {
        System.out.println("销毁servlet02");
    }
}
