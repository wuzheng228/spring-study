package chapter2.section02.topic06.demo02;

/**
 * Created by 76973 on 2021/8/8 14:59
 */
public class Order {

    private String uid;
    private String orderId;
    private double amount;

    public Order(String uid, String orderId, double amount) {
        this.uid = uid;
        this.orderId = orderId;
        this.amount = amount;
    }

    public PayState pay() {
        return pay(PayStrategy.DEFAULT_PAY);
    }

    // 不用写if else了
    public PayState pay(String key) {
        Payment payment = PayStrategy.get(key);
        System.out.println("欢迎使用" + payment.getPaytype());
        System.out.println("本次交易金额为" + amount + "开始扣款");
        return  payment.pay(uid, amount);
    }
}
