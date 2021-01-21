package com.workshop.mongodb.main.resources;

import com.workshop.mongodb.main.dto.UserDTO;
import com.workshop.mongodb.main.entities.Post;
import com.workshop.mongodb.main.entities.User;
import com.workshop.mongodb.main.repository.PostRepository;
import com.workshop.mongodb.main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value ="/posts")
@Controller
public class PostResource {


    @Autowired
    private PostRepository postRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findAll(){
        List<Post> listPost = postRepository.findAll();
        return ResponseEntity.ok().body(listPost);
    }

}
