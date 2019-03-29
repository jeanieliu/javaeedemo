package com.neuedu.dao;

import com.neuedu.entity.User;

import java.util.List;

public interface IUserDAO {
    /**
     * 根据用户名和密码进行查询，
     * 结果：1：有这条记录
     *       2：没有
     * @param username
     * @param password
     * @return
     */
    User selectByNamePassword(String username,String password);
    /**
     * 提取user表中所有数据
     * @return
     */
    List<User> selectAll();

    /**
     * 根据id进行查找user用户
     * @param id
     * @return
     */
    User selectById(Integer id);

    /**
     * 根据id进行删除操作
     * @param id
     * @return
     */
    int delele(Integer id);

    /**
     * 实现添加用户
     * @param user
     * @return
     */
    int insert(User user);

    /**
     * 修改用户
     * @param user
     * @return
     */
    int update(User user);

}
