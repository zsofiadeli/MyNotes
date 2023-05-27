package com.petproject1.daxi.controller;

import com.petproject1.daxi.model.MyNotesMenuModel;
import com.petproject1.daxi.model.MyNotesNewMenuModel;
import com.petproject1.daxi.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MenuController {

    private final MenuService service;

    @GetMapping("/menus")
    @CrossOrigin("http://localhost:4200")
    public ResponseEntity<List<MyNotesMenuModel>> getAllMenuItems() {
        return ResponseEntity.status(200).body(service.getAllMenuItems());
    }

    @PostMapping(value = "/menus", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin("http://localhost:4200")
    public ResponseEntity<MyNotesMenuModel> createNewMenuItem(@RequestBody MyNotesNewMenuModel newMenuModel) {
        return ResponseEntity.status(201).body(service.createNewMenuItem(newMenuModel));
    }
}
