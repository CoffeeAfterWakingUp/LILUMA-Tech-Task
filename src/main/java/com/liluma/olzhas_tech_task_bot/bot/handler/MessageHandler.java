package com.liluma.olzhas_tech_task_bot.bot.handler;

import com.liluma.olzhas_tech_task_bot.dto.UserDTO;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.Properties;

public interface MessageHandler extends Handler {

    void handle(UserDTO user, Message message, Properties properties);
}
