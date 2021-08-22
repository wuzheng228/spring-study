package chapter2.section02.topic08.demo02;

/**
 * Created by 76973 on 2021/8/13 21:31
 */
public class SigninForThirdService extends SiginService {

    public ResultMsg loginForQQ(String openId) {
        // openId为一个全局唯一的Id，可以将其当作用户名
        // 密码使用默认值
        // 现在系统中注册一个用户
        return loginForRegist(openId);
    }

    public ResultMsg loginForWechat(String openId) {
        return null;
    }

    public ResultMsg loginForToken(String token) {
        return null;
    }

    public ResultMsg loginForTelphone(String phone, String code) {
        return null;
    }

    private ResultMsg loginForRegist(String openId) {
        super.regist(openId, null);
        return super.login(openId, null);
    }
}
