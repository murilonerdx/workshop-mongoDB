package com.workshop.mongodb.main.service;

import com.workshop.mongodb.main.dto.UserDTO;
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

    public User insert(User obj){
        return userRepository.insert(obj);
    }

    public User fromDTO(UserDTO objDto){
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }

//    public UserDTO update(User user, User entity){
//        try{
//            Optional<UserDTO> obj = userRepository.findById(entity.getId());
//            update(entity, obj);
//            userRepository.save(obj);
//            return obj;
//        }catch(RuntimeException e){
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public void updateData(User user, User userDTO){
//        userDTO.setEmail(user.getEmail());
//        userDTO.setName(user.getName());
//    }
}
