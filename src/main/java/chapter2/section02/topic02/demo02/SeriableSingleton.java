package chapter2.section02.topic02.demo02;

import java.io.Serializable;

/**
 * Created by 76973 on 2021/8/6 9:26
 */
public class SeriableSingleton implements Serializable {

    private static SeriableSingleton instance = new SeriableSingleton();

    private SeriableSingleton() {}

    public static SeriableSingleton getInstance() {
        return instance;
    }

    private Object readResolve() {
        return instance;
    }
}
