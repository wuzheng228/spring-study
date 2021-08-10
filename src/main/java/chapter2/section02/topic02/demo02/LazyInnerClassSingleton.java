package chapter2.section02.topic02.demo02;

/**
 * Created by 76973 on 2021/8/3 21:19
 */
public class LazyInnerClassSingleton {
    private static LazyInnerClassSingleton lazy = null;
    private LazyInnerClassSingleton() {}
    public static LazyInnerClassSingleton getInstance() {
        return LazyHolder.LAZY;
    }
    public static class LazyHolder {
        public static LazyInnerClassSingleton LAZY = new LazyInnerClassSingleton();
    }
}
