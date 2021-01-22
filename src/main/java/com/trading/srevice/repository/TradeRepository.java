package com.trading.srevice.repository;

import com.trading.srevice.model.Trade;
import com.trading.srevice.model.TradeStatus;
import com.trading.srevice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TradeRepository extends JpaRepository<Trade, Long> {


    Optional<Trade> getById(Long id);

    List<Trade> getByTradeStatus(TradeStatus tradeStatus);

}