package com.company;


import java.sql.*;

public class DatabaseServer {
    private String address;
    private String database;
    private String user;
    private String password;
    private Connection conn;

    DatabaseServer(String address, String database, String user, String password) {
        this.address = address;
        this.database = database;
        this.user = user;
        this.password = password;
    }

    public void connect() throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://" + address + "/" + database + "?" +
                "user=" + user + "&password=" + password);
    }

    public Statement createStatement() throws SQLException {
        if (conn == null) {
            throw new IllegalStateException("Call connect() first!");
        }
        return conn.createStatement();
    }

    public void close() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
            }
        }
    }
}