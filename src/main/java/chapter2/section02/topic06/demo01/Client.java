package chapter2.section02.topic06.demo01;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by 76973 on 2021/8/8 13:56
 */
public class Client {
    public static void main(String[] args) {
        PromotionActivity promotionActivity = null;
        String promotionKey = "COUPON";
        if (StringUtils.equals(promotionKey,  "COUPON")) {
            promotionActivity = new PromotionActivity(new CouponStrategy());
        } else if(StringUtils.equals("CASHBACK", promotionKey)) {
            promotionActivity = new PromotionActivity(new CashbackStrategy());
        }
        promotionActivity.execute();
    }
}
