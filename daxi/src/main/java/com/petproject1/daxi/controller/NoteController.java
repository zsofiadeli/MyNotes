package com.petproject1.daxi.controller;

import com.petproject1.daxi.domain.Note;
import com.petproject1.daxi.service.NoteService;
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
public class NoteController {
    private final NoteService service;

    @GetMapping("/users/{userId}/notes")
    public ResponseEntity<List<Note>> getAllNotesFromGivenUser(@PathVariable String userId) {
        return ResponseEntity.status(200).body(service.getAllNotesFromGivenUser(userId));
    }

    @PostMapping(value = "/users/{userId}/notes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Note> createNewNote(@PathVariable String userId, @RequestBody Note note) {
        return ResponseEntity.status(201).body(service.createNewNote(userId, note));
    }

    @PutMapping(value ="/users/{userId}/notes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Note> modifyNote(@PathVariable String userId, @RequestBody Note note) {
        return ResponseEntity.status(200).body(service.modifyNote(userId, note));
    }

    @DeleteMapping(value ="/users/{userId}/notes/{noteId}")
    public ResponseEntity<Void> deleteNote(@PathVariable String userId, @PathVariable String noteId) {
        service.deleteNote(userId, noteId);
        return ResponseEntity.status(204).build();
    }
}
