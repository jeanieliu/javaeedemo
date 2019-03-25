package com.neuedu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/reg")
public class RegServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       /*使用getParamenter接收
       *   1：单选按钮请求的数据，
       *   3:select请求的是一个数据
       *   4:多行文本
       *   5：隐藏字段的数据
       *      String sex=req.getParameter("sex");
       *
       * */
      /* String sex=req.getParameter("sex");
        System.out.println(sex);*/
        /**req.getParameterValues
         *    参数：name的value值
         *    返回值：字符串数组
         *    进行输出的时候：先判断不为null
         * 2:多选按钮请求的数据的处理:
         *  3:select请求的是多个数据
         */
       String[] honnys=req.getParameterValues("honny");
       for(int i=0;honnys!=null&&i<honnys.length;i++){
           System.out.println(honnys[i]);
       }



    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
