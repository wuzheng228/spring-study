package chapter2.section02.topic04.demo02;

/**
 * Created by 76973 on 2021/8/7 8:57
 */
public class OrderService implements IOrderService {
    private OrderDao orderDao;

    public OrderService(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public int createOrder(OrderDO orderDO) {
        System.out.println("OrderService调用DAO创建订单");
        return orderDao.insert(orderDO);
    }
}
