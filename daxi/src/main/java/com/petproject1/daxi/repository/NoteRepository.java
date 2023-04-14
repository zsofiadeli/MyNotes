package com.petproject1.daxi.repository;

import com.petproject1.daxi.domain.Note;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface NoteRepository extends MongoRepository<Note, String> {

    List<Note> findNotesByCreator_Id(String userId, Sort sort);
    Optional<Note> findNoteByCreator_Id(String userId);
}
