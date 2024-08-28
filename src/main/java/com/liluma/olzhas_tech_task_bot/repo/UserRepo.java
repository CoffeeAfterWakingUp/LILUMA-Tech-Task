package com.liluma.olzhas_tech_task_bot.repo;


import com.liluma.olzhas_tech_task_bot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> getByChatId(String chatId);

}
