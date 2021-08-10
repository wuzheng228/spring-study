package chapter2.section02.topic02.demo02;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by 76973 on 2021/8/3 20:49
 */
public class Main {

    /**
     * 测试单例模式线程安全 整个方法加锁
     */
    @Test
    public void test01() {
        Thread t1 = new Thread(new ExectorThread());
        Thread t2 = new Thread(new ExectorThread());
        t1.start();
        t2.start();
        System.out.println("End");
    }

    /**
     * 测试单例模式线程安全 双检
     */
    @Test
    public void test02() {
        Thread t1 = new Thread(new ExectorThread2());
        Thread t2 = new Thread(new ExectorThread2());
        t1.start();
        t2.start();
        System.out.println("End");
    }

    /**
     * 静态内部类实现单例模式
     */
    @Test
    public void test04() {
        try {
            Class<LazyInnerClassSingleton> clazz = LazyInnerClassSingleton.class;
            Constructor<LazyInnerClassSingleton> c = clazz.getDeclaredConstructor(null);
            c.setAccessible(true);// 强制访问
            LazyInnerClassSingleton o1 = c.newInstance();
            LazyInnerClassSingleton o2 = c.newInstance();
            System.out.println(o1 == o2);
        }catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * 反射打破单例模式
     */
    @Test
    public void test05() {
        try {
            Class<LazyInnerClassSingleton2> clazz = LazyInnerClassSingleton2.class;
            Constructor<LazyInnerClassSingleton2> c = clazz.getDeclaredConstructor(null);
            c.setAccessible(true);// 强制访问
            LazyInnerClassSingleton2 o1 = c.newInstance();
            LazyInnerClassSingleton2 o2 = c.newInstance();
            System.out.println(o1 == o2);
        }catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * 序列化打破单例模式
     */
    @Test
    public void test06() {
        try {
            SeriableSingleton s1 = null;
            SeriableSingleton s2 = SeriableSingleton.getInstance();
            FileOutputStream fos = new FileOutputStream("SeriableSingleton.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s2);
            oos.flush();
            oos.close();

            FileInputStream fis = new FileInputStream("SeriableSingleton.obj");
            ObjectInputStream ooi = new ObjectInputStream(fis);
            s1 = (SeriableSingleton) ooi.readObject();
            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s1 == s2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试枚举单例模式
     */
    @Test
    public void test07() {
        try {
            EnumSingleton instance1 = null;
            EnumSingleton instance2 = EnumSingleton.getInstance();
            instance2.setData(new Object());
            FileOutputStream fos = new FileOutputStream("EnumSingleton.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(instance2);
            oos.flush();
            oos.close();

            FileInputStream fis = new FileInputStream("EnumSingleton.obj");
            ObjectInputStream ooi = new ObjectInputStream(fis);
            instance1 = (EnumSingleton) ooi.readObject();
            System.out.println(instance1);
            System.out.println(instance2);
            System.out.println(instance1 == instance2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 反射破坏枚举单例模式
     */
    @Test
    public void test08() {
        try {
            Class<EnumSingleton> clazz = EnumSingleton.class;
            Constructor<EnumSingleton> c = clazz.getDeclaredConstructor(String.class, int.class);
            c.setAccessible(true);
            EnumSingleton miHoltel = c.newInstance("miHoltel", "666");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
