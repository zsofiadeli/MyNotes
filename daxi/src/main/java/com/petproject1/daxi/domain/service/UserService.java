package com.petproject1.daxi.domain.service;

import com.petproject1.daxi.domain.entity.User;
import com.petproject1.daxi.domain.mapper.UserMapper;
import com.petproject1.daxi.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    public List<User> getUsers() {
        return repository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    public User createNewUser(User user) {
        return repository.save(user);
    }

    public void deleteUser(String userId) {
        repository.deleteById(userId);
    }

    public User modifyUser(User user) {
        Optional<User> userFromDB = repository.findById(user.getId());
        if (userFromDB.isEmpty()) {
            throw new NoSuchElementException("Invalid user");
        }
        User modifiedUser = mapper.modifyUser(user, userFromDB.get());
        return repository.save(modifiedUser);
    }
}
