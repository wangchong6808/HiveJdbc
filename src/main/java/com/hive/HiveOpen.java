package com.hive;

import java.sql.*;

public class HiveOpen {

    public static String checkConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.apache.hive.jdbc.HiveDriver");
        System.out.println("getting connection");
        Connection conn = DriverManager.getConnection("jdbc:hive2://zk0-pdlksp.o3ifriutkjkehiz1f14fkw0klf.shax.internal.chinacloudapp.cn:2181,zk2-pdlksp.o3ifriutkjkehiz1f14fkw0klf.shax.internal.chinacloudapp.cn:2181,zk3-pdlksp.o3ifriutkjkehiz1f14fkw0klf.shax.internal.chinacloudapp.cn:2181/;serviceDiscoveryMode=zooKeeper;zooKeeperNamespace=hiveserver2");
        System.out.println("got connection");
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
        return "Successful";
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        HiveOpen.checkConnection();
    }
}
