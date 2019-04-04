package com.neuedu.dao.impl;

import com.neuedu.dao.GoodsDAO;
import com.neuedu.entity.Goods;
import com.neuedu.util.QueryUpdate;
import com.neuedu.util.ResultSetObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class GoodsDAOImple implements GoodsDAO {
    @Override
    public List<Goods> selectall() {
        String sql="select * from t_good";
        List<Goods> lists= QueryUpdate.query(sql, new ResultSetObject<Goods>() {
            @Override
            public Goods getResultSetOne(ResultSet resultSet) throws SQLException {
                Goods goods=new Goods();
                goods.setGid(resultSet.getInt("gid"));
                goods.setGnum(resultSet.getString("gnum"));
                goods.setGname(resultSet.getString("gname"));
                goods.setGprice(resultSet.getBigDecimal("gprice"));
                goods.setGstock(resultSet.getInt("gstock"));
                goods.setGsell(resultSet.getInt("gsell"));
                goods.setGdesc(resultSet.getString("gdesc"));
                goods.setCid(resultSet.getInt("cid"));
                goods.setImgsrc(resultSet.getString("imgsrc"));
                return goods;
            }
        });
        return lists;
    }

    @Override
    public Goods selectById(Integer id) {
        String sql="select * from t_good where gid=?";
        List<Goods> lists= QueryUpdate.query(sql, new ResultSetObject<Goods>() {
            @Override
            public Goods getResultSetOne(ResultSet resultSet) throws SQLException {
                Goods goods=new Goods();
                goods.setGid(resultSet.getInt("gid"));
                goods.setGnum(resultSet.getString("gnum"));
                goods.setGname(resultSet.getString("gname"));
                goods.setGprice(resultSet.getBigDecimal("gprice"));
                goods.setGstock(resultSet.getInt("gstock"));
                goods.setGsell(resultSet.getInt("gsell"));
                goods.setGdesc(resultSet.getString("gdesc"));
                goods.setCid(resultSet.getInt("cid"));
                goods.setImgsrc(resultSet.getString("imgsrc"));
                return goods;
            }
        },id);

        if(lists==null){
            return null;
        }
        return lists.get(0);
    }

    @Override
    public int insertImg(String imgsrc) {
        String sql="insert into t_good(imgsrc) values(?)";
        return QueryUpdate.update(sql,imgsrc);
    }
}
