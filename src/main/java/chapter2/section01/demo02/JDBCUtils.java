package chapter2.section01.demo02;

import chapter2.section02.topic01.demo04.DBConnectionPool;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Created by 76973 on 2021/8/1 13:59
 */
public class JDBCUtils {

    private static String url = null;
    private static String username = null;
    private static String password = null;

    public JDBCUtils() { }

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream("jdbc.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public static Connection getConnectionByPool() {
        try {
            DBConnectionPool poll = DBConnectionPool.getInstance();
            return poll.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close(ResultSet rs, Statement st, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (conn != null) {
                conn.close();
            }
            if (st != null) {
                st.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
