package com.neuedu.dao.impl;

import com.neuedu.dao.IUserDAO;
import com.neuedu.entity.User;
import com.neuedu.util.QueryUpdate;
import com.neuedu.util.ResultSetObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDAOImpl implements IUserDAO {
    @Override
    public User selectByNamePassword(String username, String password) {
        String sql="select * from t_user where uname=? and upwd=?";
        List<User> lists= QueryUpdate.query(sql, new ResultSetObject<User>() {
            @Override
            public User getResultSetOne(ResultSet resultSet) throws SQLException {
                User user=new User();
                user.setUid(resultSet.getInt("uid"));
                user.setUname(resultSet.getString("uname"));
                user.setPassword(resultSet.getString("upwd"));
                user.setTelephone(resultSet.getString("telephone"));
                user.setAddress(resultSet.getString("address"));
                user.setUlevel(resultSet.getInt("ulevel"));
                return user;
            }
        },username,password);
        if(lists==null){
            return null;
        }
        return lists.get(0);
    }

    @Override
    public List<User> selectAll() {
        String sql="select * from t_user";
        List<User> lists= QueryUpdate.query(sql, new ResultSetObject<User>() {
            @Override
            public User getResultSetOne(ResultSet resultSet) throws SQLException {
                User user=new User();
                user.setUid(resultSet.getInt("uid"));
                user.setUname(resultSet.getString("uname"));
                user.setPassword(resultSet.getString("upwd"));
                user.setTelephone(resultSet.getString("telephone"));
                user.setAddress(resultSet.getString("address"));
                user.setUlevel(resultSet.getInt("ulevel"));
                return user;
            }
        });
        return lists;
    }

    @Override
    public User selectById(Integer id) {
        String sql="select * from t_user where uid=?";
        List<User> lists= QueryUpdate.query(sql, new ResultSetObject<User>() {
            @Override
            public User getResultSetOne(ResultSet resultSet) throws SQLException {
                User user=new User();
                user.setUid(resultSet.getInt("uid"));
                user.setUname(resultSet.getString("uname"));
                user.setPassword(resultSet.getString("upwd"));
                user.setTelephone(resultSet.getString("telephone"));
                user.setAddress(resultSet.getString("address"));
                user.setUlevel(resultSet.getInt("ulevel"));
                return user;
            }
        },id);
        if(lists==null){
            return null;
        }
        return lists.get(0);
    }

    @Override
    public int delele(Integer id) {
        String sql="delete from t_user where uid=?";
        return QueryUpdate.update(sql,id);
    }

    @Override
    public int insert(User user) {
        String sql="insert into t_user (uname,upwd,telephone,address,ulevel) values(?,?,?,?,?)";
        return QueryUpdate.update(sql,user.getUname(),user.getPassword(),user.getTelephone(),user.getAddress(),user.getUlevel());
    }

    @Override
    public int update(User user) {
        String sql="update t_user set uname=?,telephone=?,address=? where uid=?";
        return QueryUpdate.update(sql,user.getUname(),user.getTelephone(),user.getAddress(),user.getUid());
    }
}
