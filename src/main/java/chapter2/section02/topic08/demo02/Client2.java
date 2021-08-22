package chapter2.section02.topic08.demo02;

/**
 * Created by 76973 on 2021/8/13 22:39
 */
public class Client2 {
    public static void main(String[] args) {
        PassportForThirdAdapter adapter = new PassportForThirdAdapter();
        System.out.println(adapter.loginForQQ(new Object[]{"dasdasdasdasd"}));
    }
}
