package chapter2.section02.topic06.demo01;

/**
 * Created by 76973 on 2021/8/8 13:51
 */
public class CashbackStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("返现促销，返回的金额转到支付宝账号");
    }
}
