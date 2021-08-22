package chapter2.section02.topic08.demo02;

/**
 * Created by 76973 on 2021/8/13 22:04
 */
public interface LoginAdapter {
    boolean support(Object object);
    ResultMsg login(Object[] param, Object adapter);
}
