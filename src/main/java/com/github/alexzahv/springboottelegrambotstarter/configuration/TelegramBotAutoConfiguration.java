package com.github.alexzahv.springboottelegrambotstarter.configuration;

import com.github.alexzahv.springboottelegrambotstarter.handlers.DefaultUploadFileHandler;
import com.github.alexzahv.springboottelegrambotstarter.handlers.TelegramBotHandler;
import com.github.alexzahv.springboottelegrambotstarter.handlers.UploadFileHandler;
import com.github.alexzahv.springboottelegrambotstarter.initializr.TelegramBotBeanPostProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TelegramBotAutoConfiguration {
    @Value("${bot.token}")
    private String token;

    @Value("${bot.username}")
    private String username;

    @Bean
    @ConditionalOnMissingBean(TelegramBotHandler.class)
    public TelegramBotHandler botHandler() {
        TelegramBotHandler botHandler = new TelegramBotHandler();
        botHandler.setUsername(username);
        botHandler.setToken(token);
        return botHandler;
    }

    @Bean
    public TelegramBotBeanPostProcessor telegramBotBeanPostProcessor() {
        return new TelegramBotBeanPostProcessor();
    }

    @Bean
    @ConditionalOnMissingBean(UploadFileHandler.class)
    public UploadFileHandler uploadFileHandler() {
        DefaultUploadFileHandler fileHandler = new DefaultUploadFileHandler();
        fileHandler.setBotHandler(botHandler());
        return fileHandler;
    }
}
