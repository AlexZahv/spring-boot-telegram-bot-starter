package com.zahvalex.springboottelegrambotstarter.handlers;

import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public interface ControllerNotFoundHandler {
    void error(Update update) throws TelegramApiException;
}
