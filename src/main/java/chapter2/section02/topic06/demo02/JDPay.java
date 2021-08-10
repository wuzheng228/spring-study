package chapter2.section02.topic06.demo02;

/**
 * Created by 76973 on 2021/8/8 14:50
 */
public class JDPay extends Payment {
    @Override
    public String getPaytype() {
        return "京东";
    }

    @Override
    public double queryBalance(String uid) {
        return 500;
    }
}
