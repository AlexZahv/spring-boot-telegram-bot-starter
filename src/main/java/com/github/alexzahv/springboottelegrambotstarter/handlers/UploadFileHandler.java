package com.github.alexzahv.springboottelegrambotstarter.handlers;

import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public interface UploadFileHandler {

    void handleUpload(Update update) throws TelegramApiException;
}
