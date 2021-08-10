package chapter2.section02.topic02.demo01;

/**
 * Created by 76973 on 2021/8/3 20:33
 */
public class HungrySingleton {
    private static final HungrySingleton hungrySingleton = new HungrySingleton();

    private HungrySingleton() {};

    public static HungrySingleton getInstance() {
        return hungrySingleton;
    }
}
