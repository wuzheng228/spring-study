package chapter2.section02.topic08.demo02;

/**
 * Created by 76973 on 2021/8/13 22:31
 */
public class PassportForThirdAdapter extends SiginService implements IPasswordForThird{
    @Override
    public ResultMsg loginForQQ(Object[] params) {
        return processLogin(params, LoginForQQAdapter.class);
    }

    @Override
    public ResultMsg loginForSinaChat(Object[] params) {
        return processLogin(params, LoginForSinaAdapter.class);
    }

    public ResultMsg processLogin(Object[] params, Class<? extends LoginAdapter> clazz) {
        try {
            LoginAdapter adapter = clazz.newInstance();
            if (adapter.support(adapter)) {
                return adapter.login(params, this);
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
