package com.neuedu.servelt;

import com.neuedu.dao.IUserDAO;
import com.neuedu.dao.impl.UserDAOImpl;
import com.neuedu.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("*.user")
public class UserServlet extends HttpServlet {

    private IUserDAO userDAO=new UserDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String uri=req.getRequestURI();
        System.out.println(uri);
        //从"/"的下一位开始，到“."结束
        String path=uri.substring(uri.lastIndexOf("/")+1,uri.indexOf("."));
        System.out.println(path);

        if("list".equals(path)){
            list(req,resp);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    /**
     * 查找全部数据
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User>  userlist=userDAO.selectAll();
        req.setAttribute("users",userlist);
        req.getRequestDispatcher("userlist.jsp").forward(req,resp);
    }
    }
