package org.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseManager {

    public static Connection getConnection() throws SQLException {

        String url = "jdbc:postgresql://localhost:5432/bank";
        String user = "postgres";
        String password = "0203";

        Connection connection = DriverManager.getConnection(url, user, password);

        return connection;
    }
}