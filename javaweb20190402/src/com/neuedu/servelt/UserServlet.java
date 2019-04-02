package com.neuedu.servelt;

import com.neuedu.dao.IUserDAO;
import com.neuedu.dao.impl.UserDAOImpl;
import com.neuedu.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
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
        }else if("add".equals(path)){
            add(req,resp);
        }else if("delete".equals(path)){
            delete(req,resp);
        }else if("find".equals(path)){
            find(req,resp);
        }else if("update".equals(path)){
            update(req,resp);
        }else if("login".equals(path)){
            login(req,resp);
        }else if("checkName".equals(path)){
            checkName(req,resp);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
    public void checkName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String uname=req.getParameter("uname");
        System.out.println(uname);
        List<User> lists=userDAO.selectAll();
        boolean flag=true;//可以用，没有
        //从已知的数据中进行判断
        for(User u:lists){
            if(uname.equals(u.getUname())){
                flag=false;
                break;
            }
        }
        //{"name":value}
        String jsonString="{\"flag\":"+flag+"}";
        System.out.println(jsonString);
        resp.getWriter().print(jsonString);/*通过resp将结果传入页面*/
    }
    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1：从页面请求过来的的数据
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String ifsave=req.getParameter("ifsave");
        System.out.println("ifsave:"+ifsave);
        //2：查找有没有这个用户
        User user=userDAO.selectByNamePassword(username,password);
        HttpSession session=req.getSession();
        if(user==null){//用户是否存在
            resp.sendRedirect("login.jsp");
        }else{
            if(user.getUlevel()==0) {//是不是管理员
                session.setAttribute("user",user);
                Cookie cname = new Cookie("name", user.getUname());
                Cookie cpwd = new Cookie("password", user.getPassword());
                if(ifsave!=null && "1".equals(ifsave)) {//设置cookie

                    cname.setMaxAge(24 * 60 * 60);
                    cpwd.setMaxAge(24 * 60 * 60);

                    resp.addCookie(cname);
                    resp.addCookie(cpwd);
                }else{
                    cname.setMaxAge(0);
                    cpwd.setMaxAge(0);

                    resp.addCookie(cname);
                    resp.addCookie(cpwd);
                }
                resp.sendRedirect("list.user");

            }else{
                resp.sendRedirect("login.jsp");
            }
        }

    }
        /**
         * 收集网页中的数据，进行修改操作
         * @param req
         * @param resp
         * @throws ServletException
         * @throws IOException
         */
    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1：收集网页中的数据
        String username=req.getParameter("username");
        String uid=req.getParameter("uid");
        String telephone=req.getParameter("telephone");
        String address=req.getParameter("address");

        //2:生成对象
        if(uid!=null && !"".equals(uid)){

            User user=new User();
            user.setUid(Integer.valueOf(uid));
            user.setUname(username);
            user.setTelephone(telephone);
            user.setAddress(address);

            //3：修改的功能的实现

            int i=userDAO.update(user);
            //4：重定向到list界面
            if(i!=-1){
                resp.sendRedirect("list.user");
            }





        }




    }
        /**
         * 根据id查找一条记录
         * @param req
         * @param resp
         * @throws ServletException
         * @throws IOException
         */
    public void find(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1：获取页面中id
        String id=req.getParameter("id");
        //2：判断id是否有效
        if(id!=null&&!"".equals(id)){
            Integer idi=Integer.valueOf(id);
            //3:通过id得到数据--一条记录
            User user=userDAO.selectById(idi);
             if(user!=null){
                 req.setAttribute("user",user);
                 req.getRequestDispatcher("userupdate.jsp").forward(req,resp);
             }

        }

    }
        /**
         * 根据id进行删除
         * @param req
         * @param resp
         * @throws ServletException
         * @throws IOException
         */
    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1:从页面提取删除的id
        String id=req.getParameter("id");
          //2:删除
        if(id!=null&&!"".equals(id)) {
            int i = userDAO.delele(Integer.valueOf(id));
            if(i!=-1){
                resp.sendRedirect("list.user");
            }else{
                resp.sendRedirect("error.jsp");
            }
        }else{
            resp.sendRedirect("error.jsp");
        }

    }
        /**
         * 实现添加
         * @param req
         * @param resp
         * @throws ServletException
         * @throws IOException
         */
    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 1:提取页面中的所有表单元素的数据
         */
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String telephone=req.getParameter("telephone");
        String address=req.getParameter("address");
        /**
         * 2: 生成对象
         */
        User user=new User();
        user.setUname(username);
        user.setPassword(password);
        user.setTelephone(telephone);
        user.setAddress(address);
        user.setUlevel(1);

        /**
         * 3:添加功能的实现
         */
        int i=userDAO.insert(user);

        /**
         * 4：跳转
         */
        if(i!=-1){
           resp.sendRedirect("list.user");
        }else{
            resp.sendRedirect("useradd.jsp");
        }


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
