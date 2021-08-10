package chapter2.section02.topic04.demo02;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 76973 on 2021/8/7 9:11
 */
public class OrderServiceStaticProxy implements IOrderService{

    private SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");

    private IOrderService orderService;

    public OrderServiceStaticProxy(IOrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public int createOrder(OrderDO orderDO) {
        before();
        Long createTime = orderDO.getCreateTime();
        Integer dbRouter = Integer.valueOf(yearFormat.format(new Date(createTime)));
        System.out.println("静态代理自动分配到【DB_" + dbRouter + "】处理数据");
        DynamicDataSourceEntry.set(dbRouter);
        orderService.createOrder(orderDO);
        after();
        return 0;
    }

    private void before() {
        System.out.println("Proxy before method");
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

            IOrderService orderService = new OrderServiceStaticProxy(new OrderService(new OrderDao()));
            orderService.createOrder(orderDO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
