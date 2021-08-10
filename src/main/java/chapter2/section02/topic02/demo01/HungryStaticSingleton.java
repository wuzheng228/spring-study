package chapter2.section02.topic02.demo01;

/**
 * Created by 76973 on 2021/8/3 20:35
 */
public class HungryStaticSingleton {
    private static final HungryStaticSingleton hungrySingleton;
    static {
        hungrySingleton = new HungryStaticSingleton();
    }

    private HungryStaticSingleton() {};

    public static HungryStaticSingleton getInstance() {
        return hungrySingleton;
    }
}
