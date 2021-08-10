package chapter2.section02.topic06.demo01;

/**
 * Created by 76973 on 2021/8/8 13:53
 */
public class EmptyStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("无促销活动");
    }
}
