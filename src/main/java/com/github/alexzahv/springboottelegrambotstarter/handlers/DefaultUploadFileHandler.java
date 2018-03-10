package com.github.alexzahv.springboottelegrambotstarter.handlers;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.exceptions.TelegramApiException;


public class DefaultUploadFileHandler implements UploadFileHandler {

    private TelegramBotHandler botHandler;

    @Override
    public void handleUpload(Update update) throws TelegramApiException {
        SendMessage message = new SendMessage();
        message.setChatId(update.getMessage().getChatId());
        message.setText("Sorry, we can't process file uploading yet");
        botHandler.sendMessage(message);
    }

    public void setBotHandler(TelegramBotHandler botHandler) {
        this.botHandler = botHandler;
    }
}
