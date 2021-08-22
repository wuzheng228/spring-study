package chapter2.section02.topic10.demo02;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * Created by 76973 on 2021/8/16 22:00
 */
public class Event {
    // 事件源
    private Object source;
    // 请求对象
    private Object target;
    // 请求对象的具体回调方法
    private Method callback;
    // 触发的事件名称
    private String trigger;
    // 触发的事件的时间
    private Date date;

    public Event(Object target, Method callback) {
        this.target = target;
        this.callback = callback;
    }

    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }

    public String getTrigger() {
        return trigger;
    }

    public Event setTrigger(String trigger) {
        this.trigger = trigger;
        return this;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Method getCallback() {
        return callback;
    }

    public void setCallback(Method callback) {
        this.callback = callback;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Event{" +
                "source=" + source +
                ", target=" + target +
                ", callback=" + callback +
                ", trigger='" + trigger + '\'' +
                ", date=" + date +
                '}';
    }
}
