package chapter2.section02.topic02.demo02;

/**
 * Created by 76973 on 2021/8/3 21:19
 */
public class LazyInnerClassSingleton2 {
    private static LazyInnerClassSingleton2 lazy = null;
    private LazyInnerClassSingleton2() {
        if (LazyHolder.LAZY != null) {
            throw new RuntimeException("不允许创建多个实例");
        }
    }
    public static LazyInnerClassSingleton2 getInstance() {
        return LazyHolder.LAZY;
    }
    public static class LazyHolder {
        public static LazyInnerClassSingleton2 LAZY = new LazyInnerClassSingleton2();
    }
}
