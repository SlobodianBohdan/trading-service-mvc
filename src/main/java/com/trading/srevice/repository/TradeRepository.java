package com.trading.srevice.repository;

import com.trading.srevice.model.Trade;
import com.trading.srevice.model.TradeStatus;
import com.trading.srevice.model.TradeTime;
import com.trading.srevice.model.TradeType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TradeRepository extends JpaRepository<Trade, Long> {


    Optional<Trade> getById(Long id);

    List<Trade> getByTradeStatus(TradeStatus tradeStatus);

    List<Trade> getByTradeType(TradeType tradeType);

    List<Trade> getByTradeTime(TradeTime tradeTime);

}