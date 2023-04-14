package com.petproject1.daxi.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Getter
@Setter
@RequiredArgsConstructor
public class Note {
    @Id
    private String id;
    private String content;
    @CreatedBy
    private User creator;
    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    @Indexed(direction = IndexDirection.ASCENDING)
    private LocalDateTime lastModifiedDate;

    public String creatorId(){
        return creator.getId();
    }
}
