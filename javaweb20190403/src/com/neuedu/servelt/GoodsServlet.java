package com.neuedu.servelt;

import com.neuedu.dao.GoodsDAO;
import com.neuedu.dao.ICategoryDAO;
import com.neuedu.dao.impl.CategoryDAOImple;
import com.neuedu.dao.impl.GoodsDAOImple;
import com.neuedu.entity.Goods;
import com.neuedu.vo.GoodsVo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@WebServlet("*.goods")
public class GoodsServlet extends HttpServlet {

    private GoodsDAO goodsDAO=new GoodsDAOImple();
    private ICategoryDAO categoryDAO=new CategoryDAOImple();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String uri = req.getRequestURI();
        System.out.println(uri);
        //从"/"的下一位开始，到“."结束
        String path = uri.substring(uri.lastIndexOf("/") + 1, uri.indexOf("."));
        System.out.println(path);


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
        doPost(req,resp);
    }
    public void find(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String gid=req.getParameter("id");
      if(gid!=null) {
          Goods goods =goodsDAO.selectById(Integer.valueOf(gid));
          req.setAttribute("goods",goods);

          req.getRequestDispatcher("goodsupdate.jsp").forward(req,resp);

      }else{
          resp.sendRedirect("list.goods");
      }
    }

        public void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Goods> goods=goodsDAO.selectall();
        List<GoodsVo> goodsVos=new ArrayList<>();

        for(Goods g:goods){
            GoodsVo goodsVo=new GoodsVo();
            goodsVo.setGid(g.getGid());
            goodsVo.setGname(g.getGname());
            goodsVo.setGnum(g.getGnum());
            goodsVo.setGprice(g.getGprice());
            goodsVo.setGstock(g.getGstock());
            goodsVo.setGsell(g.getGsell());
            goodsVo.setGdesc(g.getGdesc());
            goodsVo.setCname(categoryDAO.selectById(g.getCid()).getCname());
            goodsVos.add(goodsVo);
        }

        req.setAttribute("goods",goodsVos);

        req.getRequestDispatcher("goodslist.jsp").forward(req,resp);

    }
    }
