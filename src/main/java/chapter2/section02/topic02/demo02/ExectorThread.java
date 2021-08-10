package chapter2.section02.topic02.demo02;

/**
 * Created by 76973 on 2021/8/3 20:46
 */
public class ExectorThread implements Runnable {
    @Override
    public void run() {
        LazySimpleSingleton instance = LazySimpleSingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + ":" + instance);
    }
}
