package chapter2.section02.topic09.demo02;

/**
 * Created by 76973 on 2021/8/14 22:02
 */
public class SausageDecorator extends BattercakeDecorator {

    public SausageDecorator(Battercake battercake) {
        super(battercake);
    }

    @Override
    protected void doSomething() {

    }

    @Override
    protected String getMsg() {
        return super.getMsg() + "+1个香肠";
    }

    @Override
    protected int getPrice() {
        return super.getPrice() + 2;
    }
}
