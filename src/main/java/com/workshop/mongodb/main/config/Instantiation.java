package com.workshop.mongodb.main.config;

import com.workshop.mongodb.main.dto.AuthorDTO;
import com.workshop.mongodb.main.entities.Post;
import com.workshop.mongodb.main.entities.User;
import com.workshop.mongodb.main.repository.PostRepository;
import com.workshop.mongodb.main.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

//    SimpleDateFormat sd1 = new SimpleDateFormat("dd-MM-yyyy");

    @Autowired
    private UserRepository userReposiroty;


    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... arg0) throws Exception {

        userReposiroty.deleteAll();
        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userReposiroty.saveAll(Arrays.asList(maria, alex, bob));


        postRepository.deleteAll();
        Post post1 = new Post(null, Instant.now(),"Murilo é legal","O Murilo é legal mesmo é verdade", new AuthorDTO(maria));
        Post post2 = new Post(null, Instant.now(), "O Murilo é muito legal!", "É verdade o titulo", new AuthorDTO(alex));
        Post post3 = new Post(null, Instant.now(), "O Murilo é muito muito legal mesmo mesmo!", "Nunca vi tanta verdade em um titulo", new AuthorDTO(bob));

        postRepository.saveAll(Arrays.asList(post1, post2, post3));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userReposiroty.save(maria);
    }

}