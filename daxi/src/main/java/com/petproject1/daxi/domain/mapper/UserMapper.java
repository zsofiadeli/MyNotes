package com.petproject1.daxi.domain.mapper;

import com.petproject1.daxi.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {

    public User modifyUser(User user, User userFromDB) {
        userFromDB.setName(user.getName());
        userFromDB.setUserName(user.getUserName());
        userFromDB.setPassword(user.getPassword());
        return userFromDB;
    }
}
