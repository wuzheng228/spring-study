package chapter2.section02.topic07.demo02;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by 76973 on 2021/8/10 21:30
 */
public class StudentDAO extends JdbcTemplate{

    public StudentDAO(DataSource dataSource) {
        super(dataSource);
    }

    public List<?> selectAll() {
        String sql = "select * from students";
        return executeQuery(sql, (rs, rowNum)->{
            Student student = new Student();
            student.setId(rs.getLong("id"));
            student.setAge(rs.getInt("age"));
            student.setName(rs.getString("name"));
            return student;
        }, new Object[]{});
    }
}
