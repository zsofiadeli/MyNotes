package com.petproject1.daxi.service;

import com.petproject1.daxi.domain.Note;
import com.petproject1.daxi.mapper.NoteMapper;
import com.petproject1.daxi.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;
    private final NoteMapper noteMapper;

    public List<Note> getAllNotesFromGivenUser(String userId) {
        return noteRepository.findNotesByCreator_Id(userId, Sort.by(Sort.Direction.DESC, "lastModifiedDate"));
    }

    public Note createNewNote(String userId, Note note) {
        Note noteWithAllData = noteMapper.newNote(userId, note);
        return noteRepository.save(noteWithAllData);
    }

    public Note modifyNote(String userId, Note note) {
        if (!userId.equals(note.creatorId())) {
            throw new IllegalArgumentException("User id and note creator id must be the same!");
        }
        Optional<Note> existingNote = noteRepository.findById(note.getId());

        if (existingNote.isEmpty()) {
            throw new NoSuchElementException("Invalid note");
        }

        Note modifiedNote = noteMapper.modifyNote(existingNote.get(), note);
        return noteRepository.save(modifiedNote);
    }

    public void deleteNote(String userId, String noteId) {
        Optional<Note> existingNote = noteRepository.findById(noteId);
        if (existingNote.isEmpty()) {
            throw new NoSuchElementException("Invalid note");
        }
        noteRepository.deleteById(noteId);
    }
}
