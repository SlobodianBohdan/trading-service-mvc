package com.trading.tradingservice.repository;

import com.trading.tradingservice.model.Trade;
import com.trading.tradingservice.model.TradeStatus;
import com.trading.tradingservice.model.TradeTime;
import com.trading.tradingservice.model.TradeType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TradeRepository extends JpaRepository<Trade, Long> {


    Optional<Trade> getById(Long id);

    List<Trade> getByTradeType(TradeType tradeType);

    List<Trade> getByTradeTime(TradeTime tradeTime);

    Page<Trade> findAllByTradeStatusIn(List<TradeStatus> tradeStatuses, Pageable pageable);

    Page<Trade> findAllByCurrencyPairAndTradeStatusIn(String currencyPair, List<TradeStatus> tradeStatuses, Pageable pageable);

    Page<Trade> findAllByTradeStatus(TradeStatus tradeStatus, Pageable pageable);

    Page<Trade> findAllByCurrencyPairAndTradeStatus(String currencyPair, TradeStatus tradeStatus, Pageable pageable);
}