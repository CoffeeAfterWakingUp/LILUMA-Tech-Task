package com.liluma.olzhas_tech_task_bot.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bot_user")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "chat_id")
    private String chatId;

    @Column(name = "email")
    private String email;

    @Column(name = "status")
    private String status;

    @Column(name = "registered_time")
    private LocalDateTime registeredTime;
}
