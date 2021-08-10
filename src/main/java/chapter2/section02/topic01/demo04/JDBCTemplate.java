package chapter2.section02.topic01.demo04;

import chapter2.section01.demo02.JDBCUtils;
import chapter2.section01.demo5.IRowMapper2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by 76973 on 2021/8/1 14:43
 */
public class JDBCTemplate {

    // 增 删 改
    public static void update(String sql, Object... params) {
        Connection conn = JDBCUtils.getConnectionByPool();
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
    public static <T> T query(String sql, IRowMapper2<T> rowMapper, Object... params) {
        Connection conn = JDBCUtils.getConnectionByPool();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                st.setObject(i+1, params[i]);
            }
            rs = st.executeQuery();
            return rowMapper.mapping(rs);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, st, conn);
        }
        return null;
    }
}
