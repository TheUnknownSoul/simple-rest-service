package com.service;

import com.dto.UserDto;
import com.entity.User;
import com.exception.NoSuchUserException;

import java.util.List;

public interface UserService {

    User save(UserDto userDto);

    User getUserById(Long id);

    List<User> showAllUsers();

    User putUpdate(User user) throws NoSuchUserException;

    User patchUpdate(User user);

    void deleteById(Long id);
}
