package com.neuedu.test;

import com.neuedu.dao.IUserDAO;
import com.neuedu.dao.impl.UserDAOImpl;
import com.neuedu.entity.User;

import java.util.Collections;
import java.util.List;

public class UserDAOTest {
    private static IUserDAO userDAO=new UserDAOImpl();
    public static void main(String[] args) {
       // selectall();
        //selectById();
        //insert();
       // udpate();
        delete();
    }
    public static void selectall(){
        List<User> lists= userDAO.selectAll();
        System.out.println(lists);
    }
    public static void selectById(){
        User user=userDAO.selectById(1);
        System.out.println(user);
    }
    public static void insert(){
        User user=new User();
        user.setUname("max");
        user.setPassword("789");
        user.setTelephone("12378945601");
        user.setAddress("上海");
        user.setUlevel(1);//0:管理员 1 会员
        System.out.println("影响的行数："+userDAO.insert(user));

    }

    public static void udpate(){
        User user=userDAO.selectById(3);
        user.setUname("lili");

        System.out.println("影响的行数："+userDAO.update(user));

    }
  public static void delete(){
      System.out.println("影响的行数："+userDAO.delele(3));
  }


}
