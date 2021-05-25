package com.controller;


import com.entity.User;
import com.exception.NoSuchUserException;
import com.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserServiceImpl service;

    @GetMapping
    public List<User> showAllUsers() {
        return service.showAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return service.getUserById(id);
    }
    //return user
    @PostMapping
    public void save(@RequestBody User user) {
        service.save(user);
    }

    @PutMapping
    public User putUpdate(@RequestBody User user) throws NoSuchUserException {
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
