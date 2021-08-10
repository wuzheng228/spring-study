package chapter2.section02.topic06.demo01;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 76973 on 2021/8/8 14:13
 */
public class PromotionStrategyFactory {

    private static final PromotionStrategy NON_PROMOTION = new EmptyStrategy();

    private static Map<String, PromotionStrategy> PROMOTION_STRATEGY_MAP = new HashMap<>();
    static {
        PROMOTION_STRATEGY_MAP.put(PromotionKey.COUPON, new CouponStrategy());
        PROMOTION_STRATEGY_MAP.put(PromotionKey.CASHBACK, new CashbackStrategy());
        PROMOTION_STRATEGY_MAP.put(PromotionKey.GROUPBY, new GroupbuyStrategy());
    }

    private PromotionStrategyFactory() {}

    public static PromotionStrategy getPromotionStrategy(String key) {
        PromotionStrategy promotionStrategy = PROMOTION_STRATEGY_MAP.get(key);
        return promotionStrategy == null ? NON_PROMOTION : promotionStrategy;
    }

    private interface PromotionKey {
        String COUPON = "COUPON";
        String CASHBACK = "CASHBACK";
        String GROUPBY = "GROUPBY";
    }
}
