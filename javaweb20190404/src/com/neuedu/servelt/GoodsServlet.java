package com.neuedu.servelt;

import com.neuedu.dao.GoodsDAO;
import com.neuedu.dao.ICategoryDAO;
import com.neuedu.dao.impl.CategoryDAOImple;
import com.neuedu.dao.impl.GoodsDAOImple;
import com.neuedu.entity.Goods;
import com.neuedu.util.ImgUtil;
import com.neuedu.vo.GoodsVo;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@WebServlet("*.goods")
@MultipartConfig
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
    public void imginput(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       /*
       1:图片的接收，使用getPart
       * */
        Part inputfile= req.getPart("inputfile");
        System.out.println(inputfile.getSubmittedFileName());

        /**
         * 服务器中添加的图片
         * ：使用输入流提取收的文件，存放到服务器文件中
         *   服务器的文件自己设置的
         */
        //2:设置服务器存放文件的文件夹
         String path= req.getServletContext().getRealPath("")+"imgload/";
            System.out.println("服务器的路径："+path);

        //3:在文件夹中创建文件
        //自定义文件名：文件名.扩展名
           String oldname=inputfile.getSubmittedFileName();
          String filename=String.valueOf(System.currentTimeMillis()+inputfile.getSize())+oldname.substring(oldname.lastIndexOf("."));
        System.out.println(filename);


        ImgUtil.imgController(inputfile,path,filename);

        //本地存储：
        String localpath="E:\\demo-java\\demo\\javaeedemo\\javaweb20190404\\web\\imgload\\";

         ImgUtil.imgController(inputfile,localpath,filename);
        //在数据库中存放图片的路径---服务器中文件名.扩展名  ---filename

        goodsDAO.insertImg(filename);

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
            goodsVo.setImgsrc(g.getImgsrc());
            goodsVo.setCname(categoryDAO.selectById(g.getCid()).getCname());
            goodsVos.add(goodsVo);
        }

        req.setAttribute("goods",goodsVos);

        req.getRequestDispatcher("goodslist.jsp").forward(req,resp);

    }
    }
