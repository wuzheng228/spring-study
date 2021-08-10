package chapter2.section02.topic05.demo01;

/**
 * Created by 76973 on 2021/8/8 10:32
 */
public class Client {
    public static void main(String[] args) {
        new Boss().command("登录", new Leader());
    }
}
