package chapter2.section02.topic09.demo02;

/**
 * Created by 76973 on 2021/8/14 22:05
 */
public class BaseBatterCake extends Battercake{
    @Override
    protected String getMsg() {
        return "煎饼";
    }

    @Override
    protected int getPrice() {
        return 5;
    }
}
