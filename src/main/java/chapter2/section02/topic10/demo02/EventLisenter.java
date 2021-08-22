package chapter2.section02.topic10.demo02;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 76973 on 2021/8/16 22:03
 */
public class EventLisenter {

    protected Map<String, Event> events = new HashMap<>();

    public void addLisenter(String eventType, Object target) {
        try {
            addLisenter(eventType, target, target.getClass().getMethod("on" + toUpperFirstCase(eventType), Event.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String toUpperFirstCase(String str) {
        char[] chars = str.toCharArray();
        chars[0] -= 32;
        return new String(chars);
    }

    public void addLisenter(String eventType, Object target, Method callback) {
        events.put(eventType, new Event(target, callback));
    }

    private void trigger(Event event) {
        event.setSource(this);
        event.setDate(new Date());
        try {
            if (event.getCallback() != null) {
                event.getCallback().invoke(event.getTarget(), event);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void trigger(String eventType) {
        if (!events.containsKey(eventType)) return;
        trigger(events.get(eventType).setTrigger(eventType));
    }

}
