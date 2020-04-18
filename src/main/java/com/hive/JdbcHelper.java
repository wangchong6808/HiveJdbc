package com.hive;


import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.hadoop.security.UserGroupInformation;

public class JdbcHelper {

    private static Connection con = null;

    public static Connection getConnect() {
        if (con == null) {
            try {
                con = connect();
            } catch (ClassNotFoundException | IOException | SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println(con+"  this is to get conn in helper");
        return con;
    }

    private static Connection connect() throws IOException, ClassNotFoundException, SQLException {

        org.apache.hadoop.conf.Configuration conf = new org.apache.hadoop.conf.Configuration();
        conf.set("hadoop.security.authentication", "Kerberos");
        if (System.getProperty("os.name").toLowerCase().startsWith("linux")) {
            conf.set("java.security.krb5.realm", "CORPCN.NET");
            System.setProperty("java.security.krb5.conf", "/etc/krb5.conf");

            UserGroupInformation.setConfiguration(conf);
            UserGroupInformation.loginUserFromKeytab("bdp_admin_s","/home/CORPCN/bdp_admin_s/bdp_admin_s.keytab");

            Class.forName("org.apache.hive.jdbc.HiveDriver");
            System.out.println("getting connection");
            con = DriverManager.getConnection("jdbc:hive2://zk0-p001dl.corpcn.net:2181,zk1-p001dl.corpcn.net:2181,zk3-p001dl.corpcn.net:2181/;serviceDiscoveryMode=zooKeeper;zooKeeperNamespace=hiveserver2");


        }
        return con;
    }

    public static void closeConn(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();

            }
        }
        System.out.println("close the connection");
    }

    public static void processRes(ResultSet rs, String context) throws SQLException {

        while (rs.next()) {

            System.out.println(new String(context));

        }
    }

    public static void main(String[] args)
            throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException {
        System.out.println(getConnect());
        con = null;
        closeConn(con);

    }

}
