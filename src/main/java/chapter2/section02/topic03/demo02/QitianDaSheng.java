package chapter2.section02.topic03.demo02;

import java.io.*;
import java.util.Date;

/**
 * Created by 76973 on 2021/8/6 20:04
 */
public class QitianDaSheng extends MonKey implements Cloneable, Serializable {

    public JinGuBang jinGuBang;

    public QitianDaSheng() {
        this.birthday = new Date();
        this.jinGuBang = new JinGuBang();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return this.deepClone();
    }

    private Object deepClone() {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            return ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public QitianDaSheng shallowClone(QitianDaSheng target) {
        QitianDaSheng qitianDaSheng = new QitianDaSheng();
        qitianDaSheng.height = target.height;
        qitianDaSheng.weight = target.weight;

        qitianDaSheng.jinGuBang = target.jinGuBang;
        qitianDaSheng.birthday = target.birthday;
        return qitianDaSheng;
    }
}
