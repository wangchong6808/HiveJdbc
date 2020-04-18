package com.hive;

import java.sql.SQLException;

public class Start {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println("go with esp");
        Activity_History.test();
        System.out.println("go with original");
        HiveOpen.checkConnection();
        System.out.println("go with esp");
        Activity_History.test();
        System.out.println("go with esp");
        Activity_History.test();
        System.out.println("go with original");
        HiveOpen.checkConnection();
        System.out.println("go with original");
        HiveOpen.checkConnection();
        System.out.println("go with esp");
        Activity_History.test();
    }
}
