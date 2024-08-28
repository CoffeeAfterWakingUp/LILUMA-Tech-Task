package com.liluma.olzhas_tech_task_bot.bot;


import com.liluma.olzhas_tech_task_bot.bot.handler.Handler;
import com.liluma.olzhas_tech_task_bot.bot.handler.MessageHandler;
import com.liluma.olzhas_tech_task_bot.dto.UserDTO;
import com.liluma.olzhas_tech_task_bot.enums.BotState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@Component
public class BotStateContext {

    private final Map<BotState, Handler> handlers = new HashMap<>();

    @Autowired
    public BotStateContext(List<Handler> handlers) {
        handlers.forEach(handler -> this.handlers.put(handler.getHandlerName(), handler));
    }

    public void processMessage(BotState currentState, UserDTO user, Message message, Properties properties) {
        MessageHandler handler = (MessageHandler) findMessageHandler(currentState);
        handler.handle(user, message, properties);

    }

    private Handler findMessageHandler(BotState currentState) {
        return handlers.get(currentState);
    }


}
