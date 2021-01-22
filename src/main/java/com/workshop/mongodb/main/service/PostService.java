package com.workshop.mongodb.main.service;

import com.workshop.mongodb.main.dto.UserDTO;
import com.workshop.mongodb.main.entities.Post;
import com.workshop.mongodb.main.entities.User;
import com.workshop.mongodb.main.repository.PostRepository;
import com.workshop.mongodb.main.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@EnableMongoRepositories
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text){
        return repo.findByTitleContaining(text);
    }
}