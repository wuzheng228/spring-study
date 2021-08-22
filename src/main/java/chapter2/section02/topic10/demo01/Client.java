package chapter2.section02.topic10.demo01;

/**
 * Created by 76973 on 2021/8/16 21:05
 */
public class Client {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("大司马");
        GPer gPer = GPer.getInstance();
        gPer.addObserver(teacher);
        gPer.publishQuestion(new Question("Warms", "程序员为啥这么卷？！"));
    }
}
