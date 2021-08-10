package chapter2.section02.topic04.demo03;

import java.lang.reflect.Method;

/**
 * Created by 76973 on 2021/8/7 15:23
 */
public interface MHTInvocationHandler {
    Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
