package com.petproject1.daxi.mapper;

import com.petproject1.daxi.domain.Note;
import com.petproject1.daxi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class NoteMapper {

    private final UserService userService;

    public Note newNote(String userId, Note note) {
        note.setCreator(userService.getUserById(userId));
        note.setCreatedDate(LocalDateTime.now());
        note.setLastModifiedDate(LocalDateTime.now());
        return note;
    }

    public Note modifyNote(Note existingNote, Note note) {
        existingNote.setContent(note.getContent());
        existingNote.setLastModifiedDate(LocalDateTime.now());
        return existingNote;
    }
}
