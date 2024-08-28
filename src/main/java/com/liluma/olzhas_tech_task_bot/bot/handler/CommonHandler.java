package com.liluma.olzhas_tech_task_bot.bot.handler;

import com.liluma.olzhas_tech_task_bot.bot.Bot;
import com.liluma.olzhas_tech_task_bot.bot.BotStateContext;
import com.liluma.olzhas_tech_task_bot.dto.UserDTO;
import com.liluma.olzhas_tech_task_bot.enums.BotState;
import com.liluma.olzhas_tech_task_bot.enums.UserBotStatus;
import com.liluma.olzhas_tech_task_bot.service.UserService;
import com.liluma.olzhas_tech_task_bot.utils.PropertiesReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.Properties;

@Slf4j
@Component
@RequiredArgsConstructor(onConstructor = @__(@Lazy))
public class CommonHandler {

    @Lazy
    private final Bot bot;
    private final UserService userService;
    private final BotStateContext botStateContext;
    private static final Properties PROPERTIES = PropertiesReader.getProperties();

    public void handleUserMessage(Message message) {
        UserDTO user = userService.getUser(message);
        if (message.hasText()) {
            log.info("{}({}) : {}. Status: {}", user.getUsername(), user.getChatId(), message.getText(), user.getStatus());
            handleTextMessage(message, user);
        }
    }

    public void handleTextMessage(Message message, UserDTO user) {
        if (message.getText().equals("/start") || user.getStatus().equals(UserBotStatus.MENU)) {
            botStateContext.processMessage(BotState.MENU, user, message, PROPERTIES);
        }
    }
}
