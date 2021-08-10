package chapter2.section01.demo03;

import chapter2.section01.demo02.JDBCUtils;
import chapter2.section01.domain.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 76973 on 2021/8/1 14:43
 */
public class JDBCTemplate {
    // 增 删 改
    public static void update(String sql, Object... params) {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                st.setObject(i+1, params[i]);
            }
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null, st, conn);
        }
    }
    // 查
    public static List<Student> query(String sql, Object... params) {
        List<Student> ans = new ArrayList<>();
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                st.setObject(i+1, params[i]);
            }
            rs = st.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getLong("id"));
                student.setAge(rs.getInt("age"));
                student.setName(rs.getString("name"));
                ans.add(student);
            }
            return ans;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, st, conn);
        }
        return null;
    }
}
