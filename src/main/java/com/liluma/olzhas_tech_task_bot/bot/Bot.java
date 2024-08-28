package com.liluma.olzhas_tech_task_bot.bot;

import com.liluma.olzhas_tech_task_bot.bot.handler.CommonHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Slf4j
@Component
public class Bot extends TelegramLongPollingBot {

    @Value("${bot.username}")
    private String botUsername;
    private final CommonHandler commonHandler;


    public Bot(@Value("${bot.token}") String botToken, CommonHandler commonHandler) {
        super(botToken);
        this.commonHandler = commonHandler;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();
            if (message.isUserMessage()) {
               // handler.handleUserMessage(message);
            }
        }
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }
}
