package com.workshop.mongodb.main.repository;

import com.workshop.mongodb.main.entities.Post;
import com.workshop.mongodb.main.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
