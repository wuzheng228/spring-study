package chapter2.section02.topic10.demo01;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by 76973 on 2021/8/16 20:56
 */
public class Teacher implements Observer {

    private String name;

    public Teacher(String name) {
        this.name = name;
    }
    @Override
    public void update(Observable o, Object arg) {
        GPer  gPer = (GPer) o;
        Question question = (Question) arg;
        System.out.println("================================");
        System.out.println(name + "老师，你好！\n" + "您收到一个来自" +
                gPer.getName() + "的提问：\n" + question.getContent() + "\n提问者: " + question.getUsername());
    }
}
