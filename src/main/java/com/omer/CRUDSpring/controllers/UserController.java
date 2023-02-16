package com.omer.CRUDSpring.controllers;

import com.omer.CRUDSpring.entities.User;
import com.omer.CRUDSpring.exception.UserNotFoundException;
import com.omer.CRUDSpring.repositories.UserRepository;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
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

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(repository.findById(id).orElseThrow(() -> new UserNotFoundException(id)));
    }

    @PutMapping("/user/{id}")
    ResponseEntity<User> updateUser(@RequestBody User newUser, @PathVariable("id") Long id) {
        return ResponseEntity.ok(repository.findById(id).map(user -> {
            user.setName(newUser.getName());
            user.setUsername(newUser.getUsername());
            user.setEmail(newUser.getEmail());
            return repository.save(user);
        }).orElseThrow(() -> new UserNotFoundException(id)));
    }

    @DeleteMapping("/user/{id}")
    ResponseEntity<String> deleteUser(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        repository.deleteById(id);
        return ResponseEntity.ok("usuario con imei " + id + " se elimino satisfactoriamente");
    }
}
