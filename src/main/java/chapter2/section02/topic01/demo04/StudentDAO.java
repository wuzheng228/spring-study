package chapter2.section02.topic01.demo04;

import chapter2.section01.domain.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 76973 on 2021/8/1 13:58
 */
public class StudentDAO {

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
        List<Student> query = JDBCTemplate.query(sql, rs -> {
            ArrayList<Student> ans = new ArrayList<>();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getLong("id"));
                student.setAge(rs.getInt("age"));
                student.setName(rs.getString("name"));
                ans.add(student);
            }
            return ans;
        },id);
        return query.get(0);
    }

    public Long countStudentByName(String name) {
        String sql = "select count(*) from students where name = ?";
        Long query = JDBCTemplate.query(sql, rs -> {
            ArrayList<Student> ans = new ArrayList<>();
            if (rs.next()) {
                return rs.getLong(1);
            }
            return 0L;
        },name);
        return query;
    }
}
