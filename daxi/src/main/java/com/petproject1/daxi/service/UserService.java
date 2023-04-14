package com.petproject1.daxi.service;

import com.petproject1.daxi.domain.User;
import com.petproject1.daxi.mapper.UserMapper;
import com.petproject1.daxi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<User> getUsers() {
        return userRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    public User getUserById(String userId){
        Optional<User> userById = userRepository.findById(userId);

        if(userById.isEmpty()){
            throw new NoSuchElementException("Invalid user");
        }
        return userById.get();
    }

    public User createNewUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

    public User modifyUser(User user) {
        Optional<User> userFromDB = userRepository.findById(user.getId());
        if (userFromDB.isEmpty()) {
            throw new NoSuchElementException("Invalid user");
        }
        User modifiedUser = userMapper.modifyUser(user, userFromDB.get());
        return userRepository.save(modifiedUser);
    }
}
