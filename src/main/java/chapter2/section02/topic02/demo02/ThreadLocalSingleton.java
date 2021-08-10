package chapter2.section02.topic02.demo02;

/**
 * Created by 76973 on 2021/8/7 8:35
 */
public class ThreadLocalSingleton {
    private static final ThreadLocal<ThreadLocalSingleton> threadLocalInstance =
            ThreadLocal.withInitial(() -> new ThreadLocalSingleton());
    private ThreadLocalSingleton() {}
    public static ThreadLocalSingleton getInstance() {
        return threadLocalInstance.get();
    }

    public static void main(String[] args) {
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        Thread thread1 = new Thread(() -> {
            System.out.println(ThreadLocalSingleton.getInstance());
            System.out.println(ThreadLocalSingleton.getInstance());
            System.out.println(ThreadLocalSingleton.getInstance());
            System.out.println(ThreadLocalSingleton.getInstance());
            System.out.println(ThreadLocalSingleton.getInstance());
        });
        Thread thread2 = new Thread(() -> {
            System.out.println(ThreadLocalSingleton.getInstance());
            System.out.println(ThreadLocalSingleton.getInstance());
            System.out.println(ThreadLocalSingleton.getInstance());
            System.out.println(ThreadLocalSingleton.getInstance());
        });
        thread1.start();
        thread2.start();
    }
}
