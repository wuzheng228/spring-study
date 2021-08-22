package chapter2.section02.topic10.demo02;

/**
 * Created by 76973 on 2021/8/16 22:26
 */
public class Mouse extends EventLisenter {
    public void click() {
        System.out.println("调用单击方法");
        trigger(MouseEventType.CLICK);
    }
    public void doubleClick() {
        System.out.println("调用双击方法");
        trigger(MouseEventType.DOUBLE_CLICK);
    }
}
