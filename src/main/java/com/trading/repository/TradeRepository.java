package com.trading.repository;

import com.trading.model.Trade;
import com.trading.model.TradeStatus;
import com.trading.model.TradeTime;
import com.trading.model.TradeType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TradeRepository extends JpaRepository<Trade, Long> {


    Optional<Trade> getById(Long id);

    List<Trade> getByTradeStatus(TradeStatus tradeStatus);

    List<Trade> getByTradeType(TradeType tradeType);

    List<Trade> getByTradeTime(TradeTime tradeTime);

}