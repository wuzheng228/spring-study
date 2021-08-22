package chapter2.section02.topic08.demo01;

/**
 * Created by 76973 on 2021/8/13 21:08
 */
public class Client {
    public static void main(String[] args) {
        AC220 ac220 = new AC220();
        PowerAdapter powerAdapter = new PowerAdapter(ac220);
        powerAdapter.outputDC5();
    }
}
