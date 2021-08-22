package chapter2.section02.topic08.demo02;

/**
 * Created by 76973 on 2021/8/13 22:13
 */
public class LoginForSinaAdapter implements LoginAdapter {
    @Override
    public boolean support(Object object) {
        return object instanceof LoginForSinaAdapter;
    }

    @Override
    public ResultMsg login(Object[] param, Object adapter) {
        return null;
    }
}
