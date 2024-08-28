package com.liluma.olzhas_tech_task_bot.mapper;


import com.liluma.olzhas_tech_task_bot.dto.UserDTO;
import com.liluma.olzhas_tech_task_bot.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {


    UserDTO toDto(User user);

    User toEntity(UserDTO dto);

}
