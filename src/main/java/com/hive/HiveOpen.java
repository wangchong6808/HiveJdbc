package com.hive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HiveOpen {

    public static String checkConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.apache.hive.jdbc.HiveDriver");
        System.out.println("getting connection");
        Connection con = DriverManager.getConnection("jdbc:hive2://zk0-pdlksp.o3ifriutkjkehiz1f14fkw0klf.shax.internal.chinacloudapp.cn:2181,zk2-pdlksp.o3ifriutkjkehiz1f14fkw0klf.shax.internal.chinacloudapp.cn:2181,zk3-pdlksp.o3ifriutkjkehiz1f14fkw0klf.shax.internal.chinacloudapp.cn:2181/;serviceDiscoveryMode=zooKeeper;zooKeeperNamespace=hiveserver2");
        System.out.println("got connection");
        return "Successful";
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        HiveOpen.checkConnection();
    }
}
