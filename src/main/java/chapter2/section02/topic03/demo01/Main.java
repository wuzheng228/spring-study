package chapter2.section02.topic03.demo01;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by 76973 on 2021/8/6 19:48
 */
public class Main {
    @Test
    public void test01() {
        ConcretePrototypeA concretePrototype = new ConcretePrototypeA();
        concretePrototype.setAge(12);
        concretePrototype.setName("二狗");
        ArrayList<Object> objects = new ArrayList<>();
        concretePrototype.setHobbies(objects);
        System.out.println(concretePrototype);

        Client client = new Client(concretePrototype);
        ConcretePrototypeA  concretePrototypeClone = (ConcretePrototypeA) client.startClone();
        System.out.println(concretePrototypeClone);

        System.out.println("克隆对象中的引用类型地址" + concretePrototypeClone.getHobbies());
        System.out.println("原对象中的引用类型地址" + concretePrototype.getHobbies());
        System.out.println("地址比较" + (concretePrototypeClone.getHobbies() == concretePrototype.getHobbies()));
    }
}
