package com.trading.srevice.repository;

import com.trading.srevice.model.Trade;
import com.trading.srevice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeRepository extends JpaRepository<User, Long> {


    Trade getById(Long id);

}