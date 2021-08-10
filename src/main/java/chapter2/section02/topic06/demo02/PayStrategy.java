package chapter2.section02.topic06.demo02;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 76973 on 2021/8/8 14:54
 */
public class PayStrategy {

    public final static String ALI_PAY = "AliPay";
    public final static String WECHAT_PAY = "WechatPay";
    public final static String UNION_PAY = "UNION_PAY";
    public final static String JD_PAY = "JDpay";
    public final static String DEFAULT_PAY = "Alipay";

    private static Map<String, Payment> payStrategy = new HashMap<>();
    static {
        payStrategy.put(ALI_PAY, new Alipay());
        payStrategy.put(WECHAT_PAY, new WechatPay());
        payStrategy.put(UNION_PAY, new UnionPay());
        payStrategy.put(JD_PAY, new JDPay());
        payStrategy.put(DEFAULT_PAY, new Alipay());
    }

    public static Payment get(String key) {
        if (!payStrategy.containsKey(key)) {
            return payStrategy.get(DEFAULT_PAY);
        }
        return payStrategy.get(key);
    }
}
