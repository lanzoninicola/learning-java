package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.MysqlDataSource;


public class DatabaseConnection {
    private Connection con = null;

    public static void main(String[] args) throws SQLException {
        DatabaseConnection db = new DatabaseConnection();
        
        // System.out.println(db.connect().isClosed());

        if (!db.connect().isClosed()) {
            db.makeSelect();
        }
        
    }

    public void makeSelect() throws SQLException {
        String sql = "SELECT * FROM users";
        
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getString("name"));
        }
        
    }

    public Connection connect() {

        if (con == null) {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUser("user1");
            dataSource.setPassword("DmmG@!VJD!liNVY9");
            dataSource.setServerName("localhost");
            dataSource.setDatabaseName("corso_java");

            try {
                con = dataSource.getConnection();
                
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return con;
    }





    
}
