package com.trading.srevice.service.impl;

import com.trading.srevice.model.User;
import com.trading.srevice.repository.UserRepository;
import com.trading.srevice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User animal) {
        return userRepository.save(animal);
    }

    @Override
    public User update(User animal) {
        return userRepository.save(animal);
    }

    @Override
    public User getById(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.getByEmail(email);
    }
}
