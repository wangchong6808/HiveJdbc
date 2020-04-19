package com.hive;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Activity_History {


    public static void test(String userName) throws SQLException {
        final Logger logger = LoggerFactory.getLogger(Activity_History.class);
        Connection conn = JdbcHelper.getConnect(userName);
        String sql = "SELECT * FROM rawdata_cdm.rw_cust_cdm_accnt LIMIT 10" ;

        PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        stmt.setFetchSize(1024);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            try {
                System.out.println(rs.getString("cont_id") + "    " + rs.getString("ucid"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("send A_history json success!");
        rs.close();
        stmt.close();
        conn.close();
    }
}
