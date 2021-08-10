package chapter2.section02.topic04.demo04;

import chapter2.section02.topic04.demo01.Son;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by 76973 on 2021/8/7 20:40
 */
public class CGLibMeipo implements MethodInterceptor {
    public Object getInstance(Class<?> clazz) throws Exception {
        Enhancer enhancer = new Enhancer();
        // 要把哪个设置成即将生成的新类的父类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object obj = methodProxy.invokeSuper(o, objects);
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
            System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\Resourse\\Java\\spring-study\\target\\classes\\chapter2\\section02\\topic04\\demo04\\");
            Son obj = (Son) new CGLibMeipo().getInstance(Son.class);
            obj.findLove();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
