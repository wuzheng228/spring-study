package chapter2.section02.topic04.demo02;

/**
 * Created by 76973 on 2021/8/7 9:01
 */
public class DynamicDataSourceEntry {

    public final static String DEFAULT_SOURCE = null;

    private final static ThreadLocal<String> local = new ThreadLocal<String>();

    private DynamicDataSourceEntry() {}

    // 清空数据源
    public static void clear() {
        local.remove();
    }

    // 还原数据源
    public void restore() {
        local.set(DEFAULT_SOURCE);
    }

    // 设置已知名字的数据源
    public static void set(String source) {
        local.set(source);
    }

    // 根据年份动态设置数据源
    public static void set(int year) {
        local.set("DB_" + year);
    }

}
