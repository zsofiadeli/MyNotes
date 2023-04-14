package com.petproject1.daxi.repository;

import com.petproject1.daxi.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
