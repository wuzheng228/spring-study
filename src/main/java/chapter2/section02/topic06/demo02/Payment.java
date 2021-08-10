package chapter2.section02.topic06.demo02;

/**
 * Created by 76973 on 2021/8/8 14:37
 */
public abstract class Payment {
    // 获取支付类型
    public abstract String getPaytype();
    // 查询余额
    public abstract double queryBalance(String uid);
    // 扣款支付
    public PayState pay(String uid, double amount) {
        if (queryBalance(uid) < amount) {
            return new PayState(500, "支付失败","余额不足");
        }
        return new PayState(200, "支付成功", "支付金额：" + amount);
    }
}
