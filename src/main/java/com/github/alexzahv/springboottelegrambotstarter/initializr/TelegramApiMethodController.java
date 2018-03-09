package com.github.alexzahv.springboottelegrambotstarter.initializr;

import java.lang.reflect.Method;

public class TelegramApiMethodController {
    private Object bean;
    private Method method;

    public TelegramApiMethodController(Object bean, Method method) {
        this.bean = bean;
        this.method = method;
    }

    public Object getBean() {
        return bean;
    }

    public Method getMethod() {
        return method;
    }
}
