package com.workshop.mongodb.main.service.exceptions;

public class ObjectNotFoundException extends RuntimeException{

      public ObjectNotFoundException(String msg){
          super(msg);
      }
}
