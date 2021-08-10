package chapter2.section02.topic06.demo01;

/**
 * Created by 76973 on 2021/8/8 14:20
 */
public class Client2 {
    public static void main(String[] args) {
        String promotionKey = "COUPON";
        PromotionStrategy promotionStrategy = PromotionStrategyFactory.getPromotionStrategy(promotionKey);
        promotionStrategy.doPromotion();
    }
}
