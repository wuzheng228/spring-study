package chapter2.section02.topic03.demo01;

/**
 * Created by 76973 on 2021/8/6 19:40
 */
public class Client {
    private Prototype prototype;
    public Client(Prototype prototype) {
        this.prototype = prototype;
    }
    public Prototype startClone() {
        return prototype.clone();
    }
}
