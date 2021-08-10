package chapter2.section02.topic04.demo02;

import com.mysql.cj.xdevapi.SchemaImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 76973 on 2021/8/7 10:45
 */
public class OrderServiceDynamicProxy implements InvocationHandler {

    private SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");

    private Object target;

    private Object getInstance(Object target) {
        this.target = target;
        Class<?> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before(args[0]);
        Object obj = method.invoke(target, args);
        after();
        return obj;
    }

    private void before(Object order) {
        OrderDO orderDO = (OrderDO) order;
        Long createTime = orderDO.getCreateTime();
        int dbRouter = Integer.valueOf(yearFormat.format(new Date(createTime)));
        System.out.println("静态代理自动分配到【DB_" + dbRouter + "】处理数据");
        DynamicDataSourceEntry.set(dbRouter);
    }

    private void after() {
        System.out.println("Proxy after method");
    }

    public static void main(String[] args) {
        try {
            OrderDO orderDO = new OrderDO();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date parse = dateFormat.parse("2017/02/01");
            orderDO.setCreateTime(parse.getTime());

            IOrderService orderService = (IOrderService) new OrderServiceDynamicProxy().getInstance(new OrderService(new OrderDao()));
            orderService.createOrder(orderDO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
