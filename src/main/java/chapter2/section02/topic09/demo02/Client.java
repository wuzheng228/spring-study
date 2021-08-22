package chapter2.section02.topic09.demo02;

/**
 * Created by 76973 on 2021/8/14 22:02
 */
public class Client {
    public static void main(String[] args) {
        BaseBatterCake baseBatterCake = new BaseBatterCake();
        EggDecorator eggDecorator = new EggDecorator(baseBatterCake);
        EggDecorator eggDecorator1 = new EggDecorator(eggDecorator);
        System.out.println(eggDecorator.getMsg() + "总价格：" + eggDecorator.getPrice());
        System.out.println(eggDecorator1.getMsg() + "总价格：" + eggDecorator1.getPrice());
        SausageDecorator sausageDecorator = new SausageDecorator(eggDecorator1);
        System.out.println(sausageDecorator.getMsg() + "总价格：" + sausageDecorator.getPrice());
    }
}
