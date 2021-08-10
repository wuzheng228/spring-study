package chapter2.section02.topic05.demo01;

/**
 * Created by 76973 on 2021/8/8 10:21
 */
public class EmpolyeeB implements IEmployee {
    @Override
    public void doing(String command) {
        System.out.println("我是员工A， 我现在开始干" + command + "工作");
    }
}
