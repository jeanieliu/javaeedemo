package com.neuedu.dao;

import com.neuedu.entity.Goods;

import java.util.List;

public interface GoodsDAO {

    List<Goods> selectall();

    Goods selectById(Integer id);
}
