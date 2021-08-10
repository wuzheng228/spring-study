package chapter2.section02.topic05.demo01;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 76973 on 2021/8/8 10:23
 */
public class Leader implements IEmployee {

    private Map<String, IEmployee> targets = new HashMap<>();

    public Leader() {
        targets.put("加密", new EmpolyeeA());
        targets.put("登录", new EmpolyeeB());
    }

    @Override
    public void doing(String command) {
        targets.get(command).doing(command);
    }
}
