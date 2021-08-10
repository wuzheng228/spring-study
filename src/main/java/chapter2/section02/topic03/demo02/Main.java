package chapter2.section02.topic03.demo02;

import org.junit.Test;

/**
 * Created by 76973 on 2021/8/6 20:16
 */
public class Main {
    @Test
    public void test01() {
        QitianDaSheng qitianDaSheng = new QitianDaSheng();
        try {
            QitianDaSheng clone = (QitianDaSheng) qitianDaSheng.clone();
            System.out.println("深克隆：" + (qitianDaSheng.jinGuBang == clone.jinGuBang));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        QitianDaSheng qitianDaSheng1 = qitianDaSheng.shallowClone(qitianDaSheng);
        System.out.println("浅克隆：" + (qitianDaSheng1.jinGuBang == qitianDaSheng.jinGuBang));
    }
}
