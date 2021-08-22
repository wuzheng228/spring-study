package chapter2.section02.topic10.demo01;

import java.util.Observable;

/**
 * Created by 76973 on 2021/8/16 20:45
 */
public class GPer extends Observable {
    private String name = "GPer生态圈";
    private static GPer gper = null;
    private GPer() {}

    public static GPer getInstance() {
        if (gper == null) {
            gper = new GPer();
        }
        return gper;
    }

    public String getName() {
        return name;
    }

    public void publishQuestion(Question question) {
        System.out.println(question.getUsername() + "在" + this.name + "上提交了一个问题。");
        setChanged();
        notifyObservers(question);
    }
}
