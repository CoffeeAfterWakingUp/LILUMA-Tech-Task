package com.liluma.olzhas_tech_task_bot.service;


import com.liluma.olzhas_tech_task_bot.dto.UserDTO;
import com.liluma.olzhas_tech_task_bot.entity.User;
import com.liluma.olzhas_tech_task_bot.enums.UserBotStatus;
import com.liluma.olzhas_tech_task_bot.mapper.UserMapper;
import com.liluma.olzhas_tech_task_bot.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;
    private final UserMapper userMapper;

    public void save(UserDTO userDTO) {
        if (userDTO != null) {
            User user = userMapper.toEntity(userDTO);
            userRepo.save(user);
        }
    }

    public UserDTO getUser(Message message) {
        Optional<User> userOpt = userRepo.getByChatId(message.getChatId().toString());
        if (userOpt.isEmpty()) {
            return userMapper.toDto(createBotUser(message));
        } else {
            User user = userOpt.get();
            user.setUsername(message.getFrom().getUserName());
            return userMapper.toDto(user);
        }
    }

    private User createBotUser(Message message) {
        User user = User.builder()
                .username(message.getFrom().getUserName())
                .chatId(message.getChatId().toString())
                .status(UserBotStatus.START.toString())
                .registeredTime(LocalDateTime.now())
                .build();
        return userRepo.save(user);
    }


}
