package com.neuedu.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 1:servlet中的局部参数的设置
 *    initParams = {@WebInitParam(name="charset",value="utf-8"),
         @WebInitParam(name="name",value = "tom")}
     @WebInitParam注解：  name value
     1）initParams值，传入ServletConfig，
     2）a:通过this.getServletConfig() 生成ServletConfig对象，
        b:通过init中的有参构造器完成赋值
     3)调用对象.getInitParameter("charset") 参数为name的值 ，得出value值

 * 2：项目全局的参数设置
 */
@WebServlet(urlPatterns = {"/myconfig"},
    initParams = {@WebInitParam(name="charset",value="utf-8"),
            @WebInitParam(name="name",value = "tom")}
  )
public class MyServlet03 extends HttpServlet {
     private ServletConfig config;
   /* @Override
    public void init() throws ServletException {
        config=this.getServletConfig();
        System.out.println("创建servlet03并初始化init方法");
    }*/

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config=config;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String charset=config.getInitParameter("charset");
        resp.setCharacterEncoding(charset);
        resp.getWriter().print(charset);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    public void destroy() {
        System.out.println("销毁servlet03");
    }
}
