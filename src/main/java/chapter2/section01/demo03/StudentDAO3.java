package chapter2.section01.demo03;

import chapter2.section01.demo02.JDBCUtils;
import chapter2.section01.domain.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 * Created by 76973 on 2021/8/1 13:58
 */
public class StudentDAO3 {

    // 增
    public void save(Student student) {
        String sql = "insert into students (`name`, age) values (?, ?)";
        JDBCTemplate.update(sql,student.getName(),student.getAge());
    }
    // 删
    public void delete(Long id) {
        String sql = "delete from students where id = ?";
        JDBCTemplate.update(sql, id);
    }
    // 改
    public void update(Student student) {
        String sql = "update students set `name` = ? , age = ? where id = ?";
        JDBCTemplate.update(sql, student.getName(), student.getAge(), student.getId());
    }
    // 查
    public Student findStudentById(Long id) {
        String sql = "select * from students where id = ?";
        List<Student> query = JDBCTemplate.query(sql, id);
        return query.get(0);
    }
}
