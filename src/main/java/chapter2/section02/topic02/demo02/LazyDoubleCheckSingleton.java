package chapter2.section02.topic02.demo02;

import java.util.Date;

/**
 * Created by 76973 on 2021/8/3 21:02
 */
public class LazyDoubleCheckSingleton {
    private static LazyDoubleCheckSingleton lazy;

    private Date date = null;

    private LazyDoubleCheckSingleton() {
        date = new Date();
    }
    public static LazyDoubleCheckSingleton getInstance() {
        if (lazy == null) {
            synchronized (LazyDoubleCheckSingleton.class) {
                if (lazy == null) {
                    lazy = new LazyDoubleCheckSingleton();
                } else {
                    System.out.println(lazy.date.getTime());
                }
            }
        }
        return lazy;
    }
}
