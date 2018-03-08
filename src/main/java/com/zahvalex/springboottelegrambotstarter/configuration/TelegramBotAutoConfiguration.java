package com.zahvalex.springboottelegrambotstarter.configuration;

import com.zahvalex.springboottelegrambotstarter.handlers.ControllerNotFoundHandler;
import com.zahvalex.springboottelegrambotstarter.handlers.DefaultControllerNotFoundHandler;
import com.zahvalex.springboottelegrambotstarter.handlers.TelegramBotHandler;
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
    @ConditionalOnMissingBean(ControllerNotFoundHandler.class)
    public ControllerNotFoundHandler controllerNotFoundHandler() {
        return new DefaultControllerNotFoundHandler();
    }

    @Bean
    @ConditionalOnMissingBean(TelegramBotHandler.class)
    public TelegramBotHandler botHandler() {
        TelegramBotHandler botHandler = new TelegramBotHandler();
        botHandler.setControllerNotFoundHandler(controllerNotFoundHandler());
        botHandler.setUsername(username);
        botHandler.setToken(token);
        return botHandler;
    }
}
