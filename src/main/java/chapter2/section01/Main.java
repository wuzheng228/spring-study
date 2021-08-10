package chapter2.section01;

import chapter2.section01.demo01.StudentDAO;
import chapter2.section01.demo02.StudentDAO2;
import chapter2.section01.demo03.StudentDAO3;
import chapter2.section01.demo04.StudentDAO4;
import chapter2.section01.demo5.StudentDAO5;
import chapter2.section01.domain.Student;
import org.junit.Test;

/**
 * Created by 76973 on 2021/8/1 13:17
 */
public class Main {
    @Test
    public void testDemo01() {
        Student student = new Student("张三",12);
        StudentDAO studentDAO = new StudentDAO();
//        studentDAO.save(student);
        System.out.println(studentDAO.findStudentById(1L));
        studentDAO.update(new Student(1L,"李四",13));
        System.out.println(studentDAO.findStudentById(1L));
        studentDAO.delete(1L);
        System.out.println(studentDAO.findStudentById(1L));
    }

    @Test
    public void testDemo02() {
        Student student = new Student("张三",12);
        StudentDAO2 studentDAO = new StudentDAO2();
        studentDAO.save(student);
        System.out.println(studentDAO.findStudentById(3L));
        studentDAO.update(new Student(3L,"李四",13));
        System.out.println(studentDAO.findStudentById(3L));
//        studentDAO.delete(2L);
        System.out.println(studentDAO.findStudentById(2L));
    }

    @Test
    public void testDemo03() {
        Student student = new Student("二狗",21);
        StudentDAO3 studentDAO = new StudentDAO3();
        studentDAO.save(student);
        System.out.println(studentDAO.findStudentById(4L));
        studentDAO.update(new Student(4L,"李四",13));
        System.out.println(studentDAO.findStudentById(4L));
//        studentDAO.delete(2L);
        System.out.println(studentDAO.findStudentById(4L));
    }

    @Test
    public void testDemo04() {
        Student student = new Student("二狗3",21);
        StudentDAO5 studentDAO = new StudentDAO5();
        studentDAO.save(student);
        System.out.println(studentDAO.findStudentById(5L));
        studentDAO.update(new Student(5L,"李四",13));
        System.out.println(studentDAO.findStudentById(5L));
//        studentDAO.delete(2L);
        System.out.println(studentDAO.findStudentById(4L));
        System.out.println(studentDAO.countStudentByName("李四"));
    }
}
