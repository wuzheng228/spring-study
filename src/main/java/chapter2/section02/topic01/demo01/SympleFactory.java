package chapter2.section02.topic01.demo01;

/**
 * Created by 76973 on 2021/8/1 15:59
 */
public class SympleFactory {
    public <T> T getCourse(Class<T> clazz) {
        try {
            return clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
