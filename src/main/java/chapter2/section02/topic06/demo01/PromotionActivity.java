package chapter2.section02.topic06.demo01;

/**
 * Created by 76973 on 2021/8/8 13:54
 */
public class PromotionActivity {
    private PromotionStrategy promotionStrategy;

    public PromotionActivity(PromotionStrategy strategy) {
        this.promotionStrategy = strategy;
    }

    public void execute() {
        promotionStrategy.doPromotion();
    }
}
