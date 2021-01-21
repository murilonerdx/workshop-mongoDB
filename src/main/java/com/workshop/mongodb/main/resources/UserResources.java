package com.workshop.mongodb.main.resources;

import com.workshop.mongodb.main.entities.User;
import com.workshop.mongodb.main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value ="/users")
@Controller
public class UserResources {

    @Autowired
    private UserService userService;

    @Qualifier("userService")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll(){
        List<User> list = userService.findAll();
        return ResponseEntity.ok().body(list);
    }
}
