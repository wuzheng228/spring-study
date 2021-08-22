package chapter2.section02.topic10.demo02;

/**
 * Created by 76973 on 2021/8/16 22:20
 */
public class MouseCallBack {
    public void onClick(Event e) {
        System.out.println("==========触发鼠标单机事件==========");
        System.out.println(e);
    }
    public void onDoubleClick(Event e) {
        System.out.println("==========触发鼠标双击事件==========");
        System.out.println(e);
    }
}
