package chapter2.section02.topic07.demo02;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 76973 on 2021/8/10 21:11
 */
public abstract class JdbcTemplate {
    private DataSource dataSource;

    public JdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<?> executeQuery(String sql, IRowMapper<?> rowMapper, Object[] values) {
        try {
            // 获取连接
            Connection conn = this.getConnection();
            // 创建语句集
            PreparedStatement pstm = this.createPrepareStatement(conn,sql);
            // 执行语句集
            ResultSet rs = this.executeQuery(pstm, values);
            // 处理结果集
            List<?> result = this.paresResultSet(rs, rowMapper);
            // 关闭结果集
            this.closeResultSet(rs);
            // 关闭语句集
            this.closeStatement(pstm);
            // 关闭连接
            this.closeConnection(conn);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    protected void closeConnection(Connection conn) throws Exception{
        conn.close();
    }

    protected void closeStatement(PreparedStatement pstm) throws Exception {
        pstm.close();
    }

    protected void closeResultSet(ResultSet rs) throws Exception {
        rs.close();
    }

    protected List<?> paresResultSet(ResultSet rs, IRowMapper<?> rowMapper) throws Exception {
        List<Object> result = new ArrayList<>();
        int rowNum = 1;
        while (rs.next()) {
            result.add(rowMapper.mapRow(rs, rowNum++));
        }
        return result;
    }

    protected PreparedStatement createPrepareStatement(Connection conn, String sql) throws Exception {
        return conn.prepareStatement(sql);
    }

    protected Connection getConnection() throws Exception {
        return this.dataSource.getConnection();
    }

    protected ResultSet executeQuery(PreparedStatement pstm, Object[] values) throws Exception {
        for (int i = 0; i < values.length; i++) {
           pstm.setObject(i + 1, values[i]);
        }
        return pstm.executeQuery();
    }
}
