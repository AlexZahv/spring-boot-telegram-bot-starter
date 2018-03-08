package com.zahvalex.springboottelegrambotstarter.initializr;

import java.lang.reflect.Method;
import java.util.HashMap;

public class TelegramApiMethodContainer {
    private static final TelegramApiMethodContainer instance = new TelegramApiMethodContainer();
    private HashMap<String, TelegramApiMethodController> apiMethodsMap = new HashMap<>();

    private TelegramApiMethodContainer() {
    }

    public static TelegramApiMethodContainer getInstance() {
        return instance;
    }

    public void addMappingMethod(String mapping, Method method, Object bean) {
        apiMethodsMap.put(mapping, new TelegramApiMethodController(bean, method));
    }

    public TelegramApiMethodController getByMapping(String mapping) {
        return apiMethodsMap.get(mapping);
    }
}
