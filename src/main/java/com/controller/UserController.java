package com.controller;


import com.entity.User;
import com.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users",consumes = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    UserServiceImpl service;

    @GetMapping("/allUsers")
    public List<User> showAllUsers() {
        return service.showAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return service.getUserById(id);
    }

    @PostMapping
    public void save(@RequestBody User user) {
        service.save(user);
    }

    @PutMapping
    public User putUpdate(@RequestBody User user) {
        return service.putUpdate(user);
    }

    @PatchMapping
    public User patchUpdate(@RequestBody User user) {
        return service.patchUpdate(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
