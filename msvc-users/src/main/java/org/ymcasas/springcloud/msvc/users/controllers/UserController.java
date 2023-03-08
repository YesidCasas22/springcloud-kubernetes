package org.ymcasas.springcloud.msvc.users.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.ymcasas.springcloud.msvc.users.models.User;
import org.ymcasas.springcloud.msvc.users.services.UserService;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> list() {
        return userService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<User>optionalUser=userService.byId(id);
        if(optionalUser.isPresent()){
            return ResponseEntity.ok(optionalUser.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
