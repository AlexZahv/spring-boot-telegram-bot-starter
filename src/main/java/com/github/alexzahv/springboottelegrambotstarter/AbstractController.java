package com.github.alexzahv.springboottelegrambotstarter;

import com.github.alexzahv.springboottelegrambotstarter.handlers.TelegramBotHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.api.methods.send.SendDocument;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.io.File;

public abstract class AbstractController {
    @Autowired
    protected TelegramBotHandler botHandler;

    protected Message sendMessage(Long chatId, String text) throws TelegramApiException {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(text);
        return botHandler.sendMessage(message);
    }

    protected Message sendFile(Long chatId, String fileId, String caption) throws TelegramApiException {
        SendDocument document = new SendDocument();
        document.setChatId(chatId);
        document.setCaption(caption);
        document.setDocument(fileId);
        return botHandler.sendDocument(document);
    }

    protected Message sendFile(Long chatId, File file) throws TelegramApiException {
        SendDocument document = new SendDocument();
        document.setChatId(chatId);
        document.setCaption(file.getName());
        document.setNewDocument(file);
        return botHandler.sendDocument(document);
    }
}
