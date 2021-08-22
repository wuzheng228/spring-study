package chapter2.section02.topic09.demo01;

/**
 * Created by 76973 on 2021/8/14 20:57
 */
public class BattercakeWithEggAndSausage extends BattercakeWithEgg{
    @Override
    protected String getMsg() {
        return super.getMsg() + "+1个香肠";
    }

    @Override
    protected int getPrice() {
        return super.getPrice() + 2;
    }
}
