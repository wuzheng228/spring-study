package chapter2.section02.topic02.demo02;

/**
 * Created by 76973 on 2021/8/3 20:44
 */
public class LazySimpleSingleton {
    private static  LazySimpleSingleton lazySimpleSingleton = null;
    private LazySimpleSingleton() {}
    public synchronized static LazySimpleSingleton getInstance() {
        if (lazySimpleSingleton == null) {
            lazySimpleSingleton = new LazySimpleSingleton();
        }
        return lazySimpleSingleton;
    }
}
