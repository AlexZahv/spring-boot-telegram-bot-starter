package com.zahvalex.springboottelegrambotstarter.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class DefaultControllerNotFoundHandler implements ControllerNotFoundHandler {
    @Autowired
    private TelegramBotHandler botHandler;

    @Override
    public void error(Update update) throws TelegramApiException {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId());
        sendMessage.setText("Error occured during processing request");
        botHandler.sendMessage(sendMessage);
    }
}
