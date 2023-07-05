package connect;

import java.sql.*;

public class DBConnection {
    public static Connection getConnection(){
        String url = "jdbc:mysql://localhost:3306/test";
        String id = "hr";
        String pwd = "hr";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url,id,pwd);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return conn;
    }
    public static void close(Connection conn) {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Statement stmt) {
        try {
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(PreparedStatement stmt) {
        try {
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void commit(Connection con) {
        try {
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void rollback(Connection con) {
        try {
            con.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    }

