package com.petproject1.daxi.controller;

import com.petproject1.daxi.domain.Note;
import com.petproject1.daxi.model.MyNotesNewNoteModel;
import com.petproject1.daxi.model.MyNotesNoteModel;
import com.petproject1.daxi.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class NoteController {
    private final NoteService service;

    @GetMapping("/notes")
    @CrossOrigin("http://localhost:4200")
    public ResponseEntity<List<MyNotesNoteModel>> getAllNotes() {
        return ResponseEntity.status(200).body(service.getAllNotes());
    }

    @GetMapping("/notes/topics/{menuId}")
    @CrossOrigin("http://localhost:4200")
    public ResponseEntity<List<MyNotesNoteModel>> getAllNotesByTopic(@PathVariable String menuId) {
        return ResponseEntity.status(200).body(service.getAllNotesByTopic(menuId));
    }

    @GetMapping("/notes/{userId}")
    public ResponseEntity<List<Note>> getAllNotesFromGivenUser(@RequestHeader(name = "Authorization") String authHeader) {
        return ResponseEntity.status(200).body(service.getAllNotesFromGivenUser(authHeader));
    }

    @GetMapping("/notes/{noteId}")
    public ResponseEntity<Note> getNoteById(@PathVariable String noteId) {
        return ResponseEntity.status(200).body(service.getNoteById(noteId));
    }

    @PostMapping(value = "/notes", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin("http://localhost:4200")
    public ResponseEntity<MyNotesNoteModel> createNewNote(@RequestBody MyNotesNewNoteModel newNoteModel) {
        return ResponseEntity.status(201).body(service.createNewNote(newNoteModel));
    }

    @PutMapping(value ="/notes/{noteId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Note> modifyNote(@RequestBody Note note) {
        return ResponseEntity.status(200).body(service.modifyNote(note));
    }

    @DeleteMapping(value ="/notes/{noteId}")
    public ResponseEntity<Void> deleteNote(@PathVariable String noteId) {
        service.deleteNote(noteId);
        return ResponseEntity.status(204).build();
    }
}
