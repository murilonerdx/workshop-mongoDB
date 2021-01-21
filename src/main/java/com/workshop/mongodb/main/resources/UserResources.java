package com.workshop.mongodb.main.resources;

import com.workshop.mongodb.main.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value ="/users")
public class UserResources {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll(){
        User murilo = new User("1", "Murilo", "mu-silva@outlook.com");
        User isadora = new User("2", "Isadora", "isa-pereira@outlook.com");
        List<User> list = new ArrayList<>(Arrays.asList(isadora, murilo));
        return ResponseEntity.ok().body(list);
    }
}
