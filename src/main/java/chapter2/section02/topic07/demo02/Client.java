package chapter2.section02.topic07.demo02;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

/**
 * Created by 76973 on 2021/8/10 21:42
 */
public class Client {

    public static MysqlConnectionPoolDataSource dataSource = null;

    static {
        InputStream in = Client.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        try {
            properties.load(in);
            dataSource = new MysqlConnectionPoolDataSource();
            dataSource.setURL(properties.getProperty("url"));
            dataSource.setUser(properties.getProperty("username"));
            dataSource.setPassword(properties.getProperty("password"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO(dataSource);
        List<?> result = studentDAO.selectAll();
        System.out.println(result);
    }
}
