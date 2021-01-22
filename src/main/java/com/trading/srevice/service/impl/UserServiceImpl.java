package com.trading.srevice.service.impl;

import com.trading.srevice.exception.UserNotFoundException;
import com.trading.srevice.model.User;
import com.trading.srevice.repository.UserRepository;
import com.trading.srevice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        try {
            return userRepository.save(user);
        }catch (Exception e){
            throw new UserNotFoundException("User not created!");
        }
    }

    @Override
    public User update(User user) {
        try {
            findByIdOrThrowException(userRepository, user.getId());
            return userRepository.save(user);
        } catch (UserNotFoundException e) {
            throw new UserNotFoundException("User not updated!");
        }
    }

    @Override
    public User getById(Long id) {
        try {
            findByIdOrThrowException(userRepository, id);
            return userRepository.findById(id).get();
        } catch (UserNotFoundException e) {
            throw new UserNotFoundException("User not found!");
        }
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.getByEmail(email)
                .orElseThrow(()->new UserNotFoundException("User with a specified username isn't found!"));
    }

    private <T> T findByIdOrThrowException(JpaRepository<T, Long> repository, Long id) {
        return repository.findById(id).orElseThrow(() -> new UserNotFoundException("User is not found!"));
    }
}
