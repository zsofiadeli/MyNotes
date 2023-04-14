package com.petproject1.daxi.mapper;

import com.petproject1.daxi.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User modifyUser(User user, User userFromDB) {
        userFromDB.setName(user.getName());
        userFromDB.setUserName(user.getUserName());
        userFromDB.setPassword(user.getPassword());
        return userFromDB;
    }
}
