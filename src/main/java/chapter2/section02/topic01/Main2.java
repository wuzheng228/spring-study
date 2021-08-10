package chapter2.section02.topic01;

import chapter2.section01.domain.Student;
import chapter2.section02.topic01.demo01.ICourse;
import chapter2.section02.topic01.demo01.JavaCourse;
import chapter2.section02.topic01.demo01.PythonCourse;
import chapter2.section02.topic01.demo01.SympleFactory;
import chapter2.section02.topic01.demo02.ICourseFactory;
import chapter2.section02.topic01.demo02.JavaCourseFactory;
import chapter2.section02.topic01.demo02.PythonFactory;
import chapter2.section02.topic01.demo03.CourseFactory;
import chapter2.section02.topic01.demo03.INote;
import chapter2.section02.topic01.demo03.IVideo;
import chapter2.section02.topic01.demo04.DBConnectionPool;
import chapter2.section02.topic01.demo04.StudentDAO;
import org.junit.Test;

/**
 * Created by 76973 on 2021/8/1 16:01
 */
public class Main2 {

    @Test
    public void testFactory01() {
        ICourse java = new JavaCourse();
        java.record();
        ICourse python = new PythonCourse();
        python.record();
    }

    @Test
    public void testFactory02() {
        SympleFactory sympleFactory = new SympleFactory();
        JavaCourse java = sympleFactory.getCourse(JavaCourse.class);
        java.record();
        PythonCourse python = sympleFactory.getCourse(PythonCourse.class);
        python.record();
    }

    @Test
    public void testFactory03() {
        ICourseFactory javaCourseFactory = new JavaCourseFactory();
        ICourse java = javaCourseFactory.create();
        java.record();
        ICourseFactory pythonFactory = new PythonFactory();
        ICourse python = pythonFactory.create();
        python.record();
    }

    @Test
    public void testFactory04() {
        CourseFactory javaCourseFactory = new chapter2.section02.topic01.demo03.JavaCourseFactory();
        IVideo javaVideo = javaCourseFactory.createVideo();
        javaVideo.record();
        INote javaNote = javaCourseFactory.createNote();
        javaNote.edit();
    }

    @Test
    public void testFactory05() {
        Student student = new Student("二狗3",21);
        StudentDAO studentDAO = new StudentDAO();
        studentDAO.save(student);
        System.out.println(studentDAO.findStudentById(5L));
        studentDAO.update(new Student(5L,"李四",13));
        System.out.println(studentDAO.findStudentById(5L));
//        studentDAO.delete(2L);
        System.out.println(studentDAO.findStudentById(4L));
        System.out.println(studentDAO.countStudentByName("李四"));
        try {
            DBConnectionPool.getInstance().release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
