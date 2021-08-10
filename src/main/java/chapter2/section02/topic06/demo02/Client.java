package chapter2.section02.topic06.demo02;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 * Created by 76973 on 2021/8/8 15:05
 */
public class Client {
    public static void main(String[] args) {
        // 创建订单
        Order order = new Order("1","zz197320", 63.2);
        System.out.println(order.pay(PayStrategy.JD_PAY));
    }
}
