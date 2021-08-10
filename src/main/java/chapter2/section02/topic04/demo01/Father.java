package chapter2.section02.topic04.demo01;

/**
 * Created by 76973 on 2021/8/6 21:44
 */
public class Father implements Person {

    private Person person;

    public Father(Person person) {
        this.person = person;
    }

    @Override
    public void findLove() {
        System.out.println("父亲物色对象");
        this.person.findLove();
        System.out.println("满足要求同意相亲");
    }

    public static void main(String[] args) {
        Son son = new Son();
        Father father = new Father(son);
        father.findLove();
    }
}
