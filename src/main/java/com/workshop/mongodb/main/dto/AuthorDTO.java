package com.workshop.mongodb.main.dto;

import com.workshop.mongodb.main.entities.User;

import java.io.Serializable;

public class AuthorDTO implements Serializable {
    private String id;
    private String name;

    public AuthorDTO(){

    }

    public AuthorDTO(User entity){
        id = entity.getId();
        name = entity.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
