package com.github.alexzahv.springboottelegrambotstarter.handlers;

import com.github.alexzahv.springboottelegrambotstarter.initializr.TelegramApiMethodContainer;
import com.github.alexzahv.springboottelegrambotstarter.initializr.TelegramApiMethodController;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;


public class TelegramBotHandler extends TelegramLongPollingBot {

    private ControllerNotFoundHandler controllerNotFoundHandler;
    private String token;
    private String username;

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            try {
                invokeMethodController(update);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private TelegramRequestString parseRequestString(String message) {
        message = message.trim();
        String mapping = message.split(" ")[0];
        return new TelegramRequestString(mapping, message.substring(mapping.length(), message.length()));
    }


    private void invokeMethodController(Update update) throws Exception {
        TelegramRequestString request = parseRequestString(update.getMessage().getText());
        TelegramApiMethodController methodController =
                TelegramApiMethodContainer.getInstance().getByMapping(request.getMapping());
        if (methodController != null) {
            methodController.getMethod().invoke(methodController.getBean(), update);
        } else {
            controllerNotFoundHandler.error(update);
        }
    }

    public void setControllerNotFoundHandler(ControllerNotFoundHandler controllerNotFoundHandler) {
        this.controllerNotFoundHandler = controllerNotFoundHandler;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
