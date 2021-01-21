package com.workshop.mongodb.main.service;

import com.workshop.mongodb.main.entities.User;
import com.workshop.mongodb.main.repository.UserRepository;
import com.workshop.mongodb.main.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@EnableMongoRepositories
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Qualifier("userRepository")
    public List<User> findAll() {
        return userRepository.findAll();
    }


    public User findById(String id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
}
