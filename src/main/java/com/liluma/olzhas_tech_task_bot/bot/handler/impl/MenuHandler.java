package com.liluma.olzhas_tech_task_bot.bot.handler.impl;

import com.liluma.olzhas_tech_task_bot.bot.handler.MessageHandler;
import com.liluma.olzhas_tech_task_bot.dto.UserDTO;
import com.liluma.olzhas_tech_task_bot.enums.BotState;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.Properties;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Lazy))
public class MenuHandler implements MessageHandler {

    @Override
    public BotState getHandlerName() {
        return BotState.MENU;
    }

    @Override
    public void handle(UserDTO user, Message message, Properties properties) {

    }
}
