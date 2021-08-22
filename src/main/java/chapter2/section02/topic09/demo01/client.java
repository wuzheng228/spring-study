package chapter2.section02.topic09.demo01;

/**
 * Created by 76973 on 2021/8/14 21:04
 */
public class client {
    public static void main(String[] args) {
        Battercake battercake = new Battercake();
        System.out.println(battercake.getMsg() + "总价格：" + battercake.getPrice());
        BattercakeWithEgg battercakeWithEgg = new BattercakeWithEgg();
        System.out.println(battercakeWithEgg.getMsg() + "总价格：" + battercakeWithEgg.getPrice());
        BattercakeWithEggAndSausage battercakeWithEggAndSausage = new BattercakeWithEggAndSausage();
        System.out.println(battercakeWithEggAndSausage.getMsg() + "总价格：" + battercakeWithEggAndSausage.getPrice());
    }
}
