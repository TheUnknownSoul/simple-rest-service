package com.service;

import com.dto.UserDto;
import com.entity.User;
import com.exception.NoSuchUserException;
import com.repository.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public User save(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        return repository.saveAndFlush(user);
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
    public User putUpdate(User user) throws NoSuchUserException {
        if (repository.existsById(user.getId())) {
            return repository.save(user);
        }
        throw new NoSuchUserException("No such user");
    }

    @Override
    public User patchUpdate(User user) {
        User userFromDb = getUserById(user.getId());
        if (!StringUtils.isBlank(user.getFirstName())) {
            userFromDb.setFirstName(user.getFirstName());
        }
        if (!StringUtils.isBlank(user.getLastName())) {
            userFromDb.setLastName(user.getLastName());
        }
        return repository.save(userFromDb);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
