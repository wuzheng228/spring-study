package chapter2.section02.topic02.demo02;

import java.awt.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by 76973 on 2021/8/6 13:56
 */
public class ContainerSingleton {

    private ContainerSingleton() {}

    private static Map<String, Object> ioc = new ConcurrentHashMap<>();
    public static Object getBean(String className) {
        synchronized (ioc) {
            if (!ioc.containsKey(className)) {
                Object obj = null;
                try {
                    obj = Class.forName(className).newInstance();
                    ioc.put(className, obj);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return obj;
            } else {
                return ioc.get(className);
            }
        }
    }
}
