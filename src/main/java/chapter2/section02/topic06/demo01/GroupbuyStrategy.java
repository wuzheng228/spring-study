package chapter2.section02.topic06.demo01;

/**
 * Created by 76973 on 2021/8/8 13:52
 */
public class GroupbuyStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("拼团，满20人成团，全团享受团购价");
    }
}
