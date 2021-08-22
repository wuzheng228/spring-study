package chapter2.section02.topic08.demo02;

/**
 * Created by 76973 on 2021/8/13 22:10
 */
public class LoginForQQAdapter implements LoginAdapter {
    @Override
    public boolean support(Object object) {
        return object instanceof LoginForQQAdapter;
    }

    @Override
    public ResultMsg login(Object[] param, Object obj) {
        SiginService siginService = (SiginService) obj;
        siginService.regist((String) param[0], null);
        return siginService.login((String) param[0], null);
    }
}
