package com.github.alexzahv.springboottelegrambotstarter.handlers;

public class TelegramRequestString {
    private String mapping;
    private String message;

    public TelegramRequestString(String mapping, String message) {
        this.mapping = mapping;
        this.message = message;
    }

    public String getMapping() {
        return mapping;
    }

    public String getMessage() {
        return message;
    }
}
