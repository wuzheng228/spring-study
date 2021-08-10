package chapter2.section01.demo01;

import chapter2.section01.domain.Student;

import java.sql.*;

/**
 * Created by 76973 on 2021/8/1 13:17
 */
public class StudentDAO {

    private final static String url = "jdbc:mysql://localhost:3306/jdbcdemo?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=Asia/Shanghai";
    private final static String username = "root";
    private final static String password = "123";

    // 增
    public void save(Student student) {
        String sql = "insert into students (`name`, age) values (?, ?)";
        Connection conn = null;
        PreparedStatement st = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            st = conn.prepareStatement(sql);
            st.setObject(1, student.getName());
            st.setObject(2, student.getAge());
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (st != null) {
                    st.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    // 删
    public void delete(Long id) {
        String sql = "delete from students where id = ?";
        Connection conn = null;
        PreparedStatement st = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            st = conn.prepareStatement(sql);
            st.setObject(1, id);
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (st != null) {
                    st.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    // 改
    public void update(Student student) {
        String sql = "update students set `name` = ? , age = ? where id = ?";
        Connection conn = null;
        PreparedStatement st = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            st = conn.prepareStatement(sql);
            st.setObject(1, student.getName());
            st.setObject(2, student.getAge());
            st.setObject(3, student.getId());
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (st != null) {
                    st.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    // 查
    public Student findStudentById(Long id) {
        String sql = "select * from students where id = ?";
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            st = conn.prepareStatement(sql);
            st.setObject(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                Student student = new Student();
                student.setId(rs.getLong("id"));
                student.setAge(rs.getInt("age"));
                student.setName(rs.getString("name"));
                return student;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
