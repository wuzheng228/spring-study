package chapter2.section02.topic01.demo04;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;

/**
 * Created by 76973 on 2021/8/1 19:08
 */
public class DBConnectionPool extends Pool {
    private int checkedOut; // 正在使用的链接数
    private Vector<Connection> freeConnections = new Vector<>();
    private String url = null;
    private String password = null;
    private String username = null;
    private static int num = 0; // 空闲连接数
    private static int numActive = 0; // 当前可用的连接数
    private static DBConnectionPool pool = null;

    public static synchronized DBConnectionPool getInstance() throws Exception {
        if (pool == null) {
            pool = new DBConnectionPool();
        }
        return pool;
    }

    public DBConnectionPool() {
        try {
            init();
            for (int i = 0; i < super.normalConnect; i++) {
                Connection c = newConnection();
                if (c != null) {
                    freeConnections.add(c);
                    num++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void init() throws  Exception {
        InputStream inputStream = DBConnectionPool.class.getClassLoader().getResourceAsStream(propertiesName);
        Properties properties = new Properties();
        properties.load(inputStream);
        this.username = properties.getProperty("username");
        this.password = properties.getProperty("password");
        this.url = properties.getProperty("url");
    }

    private Connection newConnection() {
        Connection con = null;
        try {
            if (username == null) {
                con = DriverManager.getConnection(url);
            } else {
                con = DriverManager.getConnection(url, username, password);
            }
        } catch (SQLException e) {
            System.out.println("无法创建这个URL连接");
            return null;
        }
        return con;
    }

    @Override
    public synchronized Connection getConnection() {
        Connection conn = null;
        if (freeConnections.size() > 0) {
            num--;
            conn = (Connection) freeConnections.firstElement();
            freeConnections.removeElementAt(0);
            try {
                if (conn.isClosed()) {
                    conn = getConnection();
                }
            } catch (SQLException e) {
                System.out.println("从连接池");
                conn = getConnection();
            }
        } else if (maxConnect == 0 || checkedOut < maxConnect) {
            conn = newConnection();
        }
        if (conn != null) {
            checkedOut++;
        }
        numActive++;
        return conn;
    }

    @Override
    public Connection getConnection(long time) {
        long startTime = new Date().getTime();
        Connection con;
        while ((con = getConnection()) == null) {
            try {
                wait(time);
            } catch (InterruptedException e) {
            }
            if ((new Date().getTime() - startTime) >= time) {
                return null;
            }
        }
        return con;
    }

    @Override
    public synchronized void freeConnection(Connection conn) {
        freeConnections.addElement(conn);
        num++;
        checkedOut--;
        numActive--;
        notifyAll();
    }

    @Override
    public int getNum() {
        return num;
    }

    @Override
    public int getNumActive() {
        return numActive;
    }

    @Override
    public synchronized void release() {
        try {
            Enumeration<Connection> elements = freeConnections.elements();
            while (elements.hasMoreElements()) {
                Connection con = (Connection) elements.nextElement();
                try {
                    con.close();
                    num--;
                } catch (SQLException e) {
                    System.out.println("无法关闭连接池中的连接");
                }
            }
            freeConnections.removeAllElements();
            numActive = 0;
        } finally {
            super.release();
        }
    }

    public void createPool() {
        pool = new DBConnectionPool();
        if (pool != null) {
            System.out.println("创建连接池成功");
        } else {
            System.out.println("创建连接池失败");
        }
    }
}
