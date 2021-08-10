package chapter2.section02.topic04.demo03;

import chapter2.section02.topic04.demo01.Person;
import chapter2.section02.topic04.demo01.Son;

import java.lang.reflect.Method;

/**
 * Created by 76973 on 2021/8/7 17:30
 */
public class MHTMeipo implements MHTInvocationHandler{

    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        Class<?> clazz = target.getClass();
        return MHTProxy.newProxyInstance(new MHTClassLoader(), clazz.getInterfaces(), this);
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
        Person person = (Person)new MHTMeipo().getInstance(new Son());
        person.findLove();
    }
}
