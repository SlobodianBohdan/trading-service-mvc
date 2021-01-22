package com.trading.srevice.repository;

import com.trading.srevice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User getByEmail (String email);
}
