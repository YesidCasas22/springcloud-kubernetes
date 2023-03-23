package org.ymcasas.springcloud.msvc.users.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.ymcasas.springcloud.msvc.users.models.User;
import org.ymcasas.springcloud.msvc.users.services.UserService;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/users")
    public List<User> list() {
        return userService.list();
    }

    @GetMapping(value = "/users/{id}")
    public User findById(@PathVariable Long id) {
        return userService.byId(id);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<?> edit(@RequestBody User user, @PathVariable Long id) {
        User userDb = userService.byId(id);
        userDb.setName(user.getName());
        userDb.setEmail(user.getEmail());
        userDb.setPassword(user.getPassword());
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userDb));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
