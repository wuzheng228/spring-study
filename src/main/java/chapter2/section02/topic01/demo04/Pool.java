package chapter2.section02.topic01.demo04;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by 76973 on 2021/8/1 18:39
 */
public abstract class Pool {

    public String propertiesName = "jdbc.properties";
    private static Pool pool = null;
    protected int maxConnect = 100;
    protected int normalConnect = 10;
    protected String driverName = "";
    protected Driver driver = null;

    protected Pool() {
        try {
            init();
            loadDriver();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void init() throws IOException {
        InputStream inputStream = Pool.class.getClassLoader().getResourceAsStream(propertiesName);
        Properties properties = new Properties();
        properties.load(inputStream);
        this.driverName = properties.getProperty("driverName");
        this.maxConnect = Integer.parseInt(properties.getProperty("maxConnect"));
        this.normalConnect = Integer.parseInt(properties.getProperty("normalConnect"));
    }

    private void loadDriver() {
        try {
            this.driver = (Driver) Class.forName(this.driverName).newInstance();
            DriverManager.registerDriver(this.driver);
            System.out.println("成功注册JDBC驱动");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("注册JDBC驱动失败");
        }
    }

    public abstract Connection getConnection();

    public abstract Connection getConnection(long time);

    public abstract void freeConnection(Connection conn);

    public abstract int getNum();

    public abstract int getNumActive();

    protected synchronized void release() {
        // 撤销驱动
        try {
            DriverManager.deregisterDriver(driver);
            System.out.println("注销JDBC驱动程序" + driver.getClass().getName());
        } catch (SQLException e) {
            System.out.println("无法注销JDBC驱动程序的注册" + driver.getClass().getName());
        }
    }
}
