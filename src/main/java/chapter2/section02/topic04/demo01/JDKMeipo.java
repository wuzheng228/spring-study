package chapter2.section02.topic04.demo01;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by 76973 on 2021/8/7 10:15
 */
public class JDKMeipo implements InvocationHandler {

    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        Class<?> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object obj = method.invoke(this.target, args);
        after();
        return obj;
    }

    private void before() {
        System.out.println("我是媒婆现在给你寻找对象，已确认需求");
        System.out.println("开始物色对象");
    }

    private void after() {
        System.out.println("物色结束，您满意吗");
    }

    public static void main(String[] args) {
        try {
            Person obj = (Person) new JDKMeipo().getInstance(new Son());
            obj.findLove();

            byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0.class", new Class[] {Person.class});
            FileOutputStream fos = new FileOutputStream("E://$Proxy0.class");
            fos.write(bytes);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
