package com.github.alexzahv.springboottelegrambotstarter;

import com.github.alexzahv.springboottelegrambotstarter.handlers.TelegramBotHandler;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractController {
    @Autowired
    protected TelegramBotHandler botHandler;
}
