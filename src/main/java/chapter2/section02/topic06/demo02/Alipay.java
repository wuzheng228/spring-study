package chapter2.section02.topic06.demo02;

/**
 * Created by 76973 on 2021/8/8 14:47
 */
public class Alipay extends Payment{
    @Override
    public String getPaytype() {
        return "支付宝";
    }

    @Override
    public double queryBalance(String uid) {
        return 900;
    }
}
