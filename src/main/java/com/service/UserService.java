package com.service;

import com.entity.User;

import java.util.List;

public interface UserService {

    void save(User user);
    User getUserById(Long id);
    List<User> showAllUsers();
    User putUpdate(User user);
    User patchUpdate(User user);
    void deleteById(Long id);
}
