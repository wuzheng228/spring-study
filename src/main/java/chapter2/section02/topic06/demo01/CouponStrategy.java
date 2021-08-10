package chapter2.section02.topic06.demo01;

/**
 * Created by 76973 on 2021/8/8 13:47
 */
public class CouponStrategy implements PromotionStrategy{
    @Override
    public void doPromotion() {
        System.out.println("领取优惠券，课程的价格直减领取优惠券面值");
    }
}
