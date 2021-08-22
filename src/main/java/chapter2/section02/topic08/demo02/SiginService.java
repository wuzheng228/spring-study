package chapter2.section02.topic08.demo02;

/**
 * Created by 76973 on 2021/8/13 21:22
 */
public class SiginService {

    // 注册方法
    public ResultMsg regist(String username, String password) {
        return new ResultMsg(200, "注册成功", new Member());
    }

    // 登录方法
    public ResultMsg login(String username, String password) {
        return null;
    }

}
