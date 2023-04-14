package com.petproject1.daxi.domain.repository;

import com.petproject1.daxi.domain.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
