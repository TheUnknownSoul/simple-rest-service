package com.controller;


import com.dto.UserDto;
import com.entity.User;
import com.exception.NoSuchUserException;
import com.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping
    public User save(@RequestBody UserDto userDto) {
        return service.save(userDto);
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