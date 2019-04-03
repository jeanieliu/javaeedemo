package com.neuedu.test;

import com.neuedu.dao.ICategoryDAO;
import com.neuedu.dao.impl.CategoryDAOImple;
import com.neuedu.entity.Category;

import java.util.List;

public class CategoryDAOTest {
   private static ICategoryDAO categoryDAO=new CategoryDAOImple();
    public static void main(String[] args) {
      // selectAll();
      //  selectById();
       // insert();
       // update();
        delete();
    }

    public static void selectAll(){
        List<Category> lists= categoryDAO.selectAll();
        for(Category c:lists){
            System.out.println(c);
        }
    }
    public static void selectById(){

        System.out.println(categoryDAO.selectById(1));
    }

    public static void insert(){
        Category category=new Category();
        category.setCname("月季");
        System.out.println("影响的行数："+categoryDAO.insert(category));
    }

    public static void update(){
        Category category=new Category();
        category.setCid(5);
        category.setCname("玫瑰");
        System.out.println("影响的行数："+categoryDAO.update(category));
    }

    public static void delete(){
        System.out.println("影响的行数："+categoryDAO.delete(5));
    }
}
