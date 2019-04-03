package com.neuedu.test;

import com.neuedu.util.SQLUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlTest {
    public static void main(String[] args) throws SQLException {
        /***
         * 通过查找user表中全部数据进行测试
         */

        Connection connection=null;
        PreparedStatement pstm=null;
        ResultSet rs=null;
        String sql="select * from t_user";
        connection= SQLUtil.getConn();
        pstm=connection.prepareStatement(sql);
        rs=pstm.executeQuery();
        while (rs.next()){
            System.out.println(rs.getObject(1)+"  "+rs.getObject(2));
        }

    }
}
