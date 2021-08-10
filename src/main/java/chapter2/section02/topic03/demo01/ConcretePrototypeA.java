package chapter2.section02.topic03.demo01;

import java.util.List;

/**
 * Created by 76973 on 2021/8/6 19:36
 */
public class ConcretePrototypeA implements Prototype{
    private int age;
    private String name;
    private List hobbies;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getHobbies() {
        return hobbies;
    }

    public void setHobbies(List hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public ConcretePrototypeA clone() {
        ConcretePrototypeA concretePrototype = new ConcretePrototypeA();
        concretePrototype.setAge(this.age);
        concretePrototype.setName(this.name);
        concretePrototype.setHobbies(this.hobbies);// 复制的只是引用地址
        return concretePrototype;
    }
}
