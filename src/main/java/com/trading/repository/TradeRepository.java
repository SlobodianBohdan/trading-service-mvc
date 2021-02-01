package com.trading.repository;

import com.trading.model.Trade;
import com.trading.model.TradeStatus;
import com.trading.model.TradeTime;
import com.trading.model.TradeType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface TradeRepository extends JpaRepository<Trade, Long> {


    Optional<Trade> getById(Long id);

    Page<Trade> findAllByTradeStatus(TradeStatus tradeStatus, Pageable pageable);

    List<Trade> getByTradeType(TradeType tradeType);

    List<Trade> getByTradeTime(TradeTime tradeTime);

    Page<Trade> findAllByTradeStatusIn(List<TradeStatus> tradeStatuses, Pageable pageable);

    Page<Trade> findAllByCurrencyPairAndTradeStatusIn(String nameQuery, List<TradeStatus> tradeStatuses, Pageable pageable);
}