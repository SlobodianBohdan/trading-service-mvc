package com.trading.srevice.service;

import com.trading.srevice.model.User;

public interface UserService {

    User create(User animal);

    User update(User animal);

    User getById(Long id);

    User getByEmail(String email);

}
