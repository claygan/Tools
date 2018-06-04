package com.quest.test.guava.eventBus;

import com.google.common.eventbus.EventBus;

/**
 * Created by Quest on 2018/6/4.
 */
public class EventBusCenter {
    private static EventBus eventBus = new EventBus();

    public EventBusCenter() {
    }

    public static EventBus getInstance(){
        return eventBus;
    }

    public static void register(Object object) {
        eventBus.register(object);
    }

    public static void unRegister(Object object) {
        eventBus.unregister(object);
    }

    public static void post(Object object) {
        eventBus.post(object);
    }
}
