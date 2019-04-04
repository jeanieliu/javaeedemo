package com.neuedu.dao.impl;

import com.neuedu.dao.ICategoryDAO;
import com.neuedu.entity.Category;
import com.neuedu.util.QueryUpdate;
import com.neuedu.util.ResultSetObject;
import com.neuedu.util.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CategoryDAOImple implements ICategoryDAO {
    @Override
    public List<Category> selectAll() {
        String sql="SELECT * FROM t_category";
        List<Category> lists= QueryUpdate.query(sql, new ResultSetObject<Category>() {
            @Override
            public Category getResultSetOne(ResultSet resultSet) throws SQLException {
                Category category=new Category();
                category.setCid(resultSet.getInt("cid"));
                category.setCname(resultSet.getString("cname"));
                return category;
            }
        });
        return lists;
    }

    @Override
    public Category selectById(Integer id) {
        String sql="SELECT * FROM  t_category where cid=?";
        List<Category> lists= QueryUpdate.query(sql, new ResultSetObject<Category>() {
            @Override
            public Category getResultSetOne(ResultSet resultSet) throws SQLException {
                Category category=new Category();
                category.setCid(resultSet.getInt("cid"));
                category.setCname(resultSet.getString("cname"));
                return category;
            }
        },id);
        if(lists==null){
            return null;
        }
        return lists.get(0);
    }

    @Override
    public int delete(Integer id) {
        String sql="delete from t_category where cid=?";
        return QueryUpdate.update(sql,id);
    }

    @Override
    public int update(Category cate) {
        String sql="update t_category set cname=? where cid=?";
        return QueryUpdate.update(sql,cate.getCname(),cate.getCid());
    }

    @Override
    public int insert(Category cate) {
        String sql="insert into t_category (cname) values(?)";
        return QueryUpdate.update(sql,cate.getCname());
    }
}
