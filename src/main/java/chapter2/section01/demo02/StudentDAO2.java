package chapter2.section01.demo02;

import chapter2.section01.domain.Student;

import java.sql.*;

/**
 * Created by 76973 on 2021/8/1 13:58
 */
public class StudentDAO2 {
    // 增
    public void save(Student student) {
        String sql = "insert into students (`name`, age) values (?, ?)";
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(sql);
            st.setObject(1, student.getName());
            st.setObject(2, student.getAge());
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null,st,conn);
        }
    }
    // 删
    public void delete(Long id) {
        String sql = "delete from students where id = ?";
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(sql);
            st.setObject(1, id);
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null, st, conn);
        }
    }
    // 改
    public void update(Student student) {
        String sql = "update students set `name` = ? , age = ? where id = ?";
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(sql);
            st.setObject(1, student.getName());
            st.setObject(2, student.getAge());
            st.setObject(3, student.getId());
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null, st, conn);
        }
    }
    // 查
    public Student findStudentById(Long id) {
        String sql = "select * from students where id = ?";
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
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
            JDBCUtils.close(rs, st, conn);
        }
        return null;
    }
}
