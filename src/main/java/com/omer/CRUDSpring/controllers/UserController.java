package com.omer.CRUDSpring.controllers;

import com.omer.CRUDSpring.entities.User;
import com.omer.CRUDSpring.repositories.UserRepository;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {
    private final UserRepository repository;

    @PostMapping("/user")
    private ResponseEntity<User> saveUser(@RequestBody User User) {
        return ResponseEntity.ok(repository.save(repository.save(User)));
    }

    @GetMapping("/users")
    private ResponseEntity<List<User>> getAllUser() {
        return ResponseEntity.ok(repository.findAll());
    }
}
