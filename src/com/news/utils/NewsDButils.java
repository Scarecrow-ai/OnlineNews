package com.news.utils;

import java.sql.*;

public class NewsDButils {
    private Connection conn;
    private Statement stmt;
    ResultSet rs;


    public void getConnect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/news?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "abc123";
        try {
            conn
                    = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTable(String sql) throws ClassNotFoundException, SQLException {
        stmt.executeUpdate(sql);
        stmt.close();
        conn.close();
    }

    public ResultSet selectTable(String sql) throws ClassNotFoundException, SQLException {
        rs = stmt.executeQuery(sql);
        return rs;
    }

    public void getClose() {
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
