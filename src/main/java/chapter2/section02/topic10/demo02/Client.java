package chapter2.section02.topic10.demo02;

/**
 * Created by 76973 on 2021/8/16 22:30
 */
public class Client {
    public static void main(String[] args) {
        Mouse mouse = new Mouse();
        MouseCallBack callBack = new MouseCallBack();
        mouse.addLisenter(MouseEventType.CLICK, callBack);
        mouse.addLisenter(MouseEventType.DOUBLE_CLICK, callBack);
        mouse.click();
        mouse.doubleClick();
    }
}
