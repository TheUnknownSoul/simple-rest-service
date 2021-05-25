package com.service;

import com.entity.User;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;


    @Override
    public void save(User user) {
        repository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public List<User> showAllUsers() {
        return repository.findAll();
    }

    @Override
    public User putUpdate(User user) {
        getUserById(user.getId());
        return repository.save(user);
    }

    @Override
    public User patchUpdate(User user) {
        User user1 = getUserById(user.getId());
        if (user.getFirstName() != null && !user.getFirstName().equals("")) {
            user1.setFirstName(user.getFirstName());
        }
        if (user.getLastName() != null && !user.getLastName().equals("")) {
            user1.setLastName(user.getLastName());
        }
        return repository.save(user1);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
