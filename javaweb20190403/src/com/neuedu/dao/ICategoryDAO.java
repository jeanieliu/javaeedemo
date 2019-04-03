package com.neuedu.dao;

import com.neuedu.entity.Category;

import java.util.List;

public interface ICategoryDAO {

    List<Category> selectAll();

    Category selectById(Integer id);

    int delete(Integer id);

    int update(Category cate);

    int insert(Category cate);

}
