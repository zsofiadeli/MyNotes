package com.petproject1.daxi.controller;

import com.petproject1.daxi.domain.entity.User;
import com.petproject1.daxi.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final UserService service;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.status(200).body(service.getUsers());
    }

    @PostMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createNewUser(@RequestBody User user) {
        return ResponseEntity.status(201).body(service.createNewUser(user));
    }

    @PutMapping(value ="/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> modifyUser(@RequestBody User user) {
        return ResponseEntity.status(200).body(service.modifyUser(user));
    }

    @DeleteMapping(value ="/users/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
        service.deleteUser(userId);
        return ResponseEntity.status(204).build();
    }
}
