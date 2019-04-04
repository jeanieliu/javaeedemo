package com.neuedu.servelt;

import com.neuedu.dao.ICategoryDAO;
import com.neuedu.dao.impl.CategoryDAOImple;
import com.neuedu.entity.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@WebServlet("*.cate")
public class CategoryServlet extends HttpServlet {

    private ICategoryDAO categoryDAO = new CategoryDAOImple();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        System.out.println(uri);
        //从"/"的下一位开始，到“."结束
        String path = uri.substring(uri.lastIndexOf("/") + 1, uri.indexOf("."));
        System.out.println(path);

       /* if("list".equals(path)){
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
        }*/
        //通过反射来实现方法的调用
        try {
            Method method = this.getClass().getMethod(path, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, req, resp);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    public void cateall(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> lists = categoryDAO.selectAll();
        //[{"cid":1,"cname":"玫瑰"},{"cid":2,"cname":"月季"},{.....}]

        StringBuffer sb=new StringBuffer();

        sb.append("[");

        int n=0;

        for(Category c:lists){
            n++;
            if(n==lists.size()){
                sb.append("{\"cid\":" + c.getCid() + ",\"cname\":\"" + c.getCname() + "\"}");
            }else {
                sb.append("{\"cid\":" + c.getCid() + ",\"cname\":\"" + c.getCname() + "\"},");
            }
        }
        sb.append("]");
        System.out.println(String.valueOf(sb));
       resp.getWriter().print(String.valueOf(sb));
    }
        public void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> lists = categoryDAO.selectAll();
        req.setAttribute("cates", lists);
        req.getRequestDispatcher("catelist.jsp").forward(req, resp);
    }

    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cname = req.getParameter("cname");
        Category category = new Category();
        category.setCname(cname);

        int i = categoryDAO.insert(category);

        resp.sendRedirect("list.cate");

    }

    public void find(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cid = req.getParameter("id");
        if (cid != null) {
            Category category = categoryDAO.selectById(Integer.valueOf(cid));
            req.setAttribute("cate", category);
            req.getRequestDispatcher("cateupdate.jsp").forward(req, resp);

        }
        resp.sendRedirect("list.cate");
    }

    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cname = req.getParameter("cname");
        String cid = req.getParameter("cid");
        if (cid != null) {
            Category category = new Category();
            category.setCname(cname);
            category.setCid(Integer.valueOf(cid));

            int i = categoryDAO.update(category);
        }
        resp.sendRedirect("list.cate");
    }

    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cid = req.getParameter("id");
        if (cid != null) {
            int i= categoryDAO.delete(Integer.valueOf(cid));
        }
        resp.sendRedirect("list.cate");
    }
}
