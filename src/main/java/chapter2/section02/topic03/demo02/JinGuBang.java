package chapter2.section02.topic03.demo02;

import java.io.Serializable;

/**
 * Created by 76973 on 2021/8/6 20:01
 */
public class JinGuBang implements Serializable {
    public float h = 100;
    public float d = 10;
    public void big() {
        this.h *= 2;
        this.d *= 2;
    }
    public void small() {
        this.h /= 2;
        this.d /= 2;
    }
}
