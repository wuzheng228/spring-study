package chapter2.section02.topic09.demo02;

/**
 * Created by 76973 on 2021/8/14 21:22
 */
public abstract class BattercakeDecorator extends Battercake{

    private Battercake battercake;

    public BattercakeDecorator(Battercake battercake) {
        this.battercake = battercake;
    }

    protected abstract void doSomething();

    @Override
    protected String getMsg() {
        return this.battercake.getMsg();
    }

    @Override
    protected int getPrice() {
        return this.battercake.getPrice();
    }
}
