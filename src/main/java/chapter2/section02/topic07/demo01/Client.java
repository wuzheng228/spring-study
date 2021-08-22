package chapter2.section02.topic07.demo01;

/**
 * Created by 76973 on 2021/8/10 21:02
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("--Java架构师课程--");
        NetworkCourse javaCourse = new JavaCourse();
        javaCourse.createCourse();

        System.out.println("--大数据课程--");
        NetworkCourse bigDataCourse = new BigDataCourse(true);
        bigDataCourse.createCourse();
    }
}
