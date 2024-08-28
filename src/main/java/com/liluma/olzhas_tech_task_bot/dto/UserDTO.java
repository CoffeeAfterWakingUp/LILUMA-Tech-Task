package com.liluma.olzhas_tech_task_bot.dto;


import com.liluma.olzhas_tech_task_bot.enums.UserBotStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;
    private String fullName;
    private String username;
    private String chatId;
    private String email;
    private UserBotStatus status;
    private LocalDateTime registeredTime;

}
