package com.trading.service;

import com.trading.model.TradeTime;
import com.trading.model.Trade;
import com.trading.model.TradeStatus;
import com.trading.model.TradeType;

import java.util.List;

public interface TradeService {

    Trade create(Trade trade);

    boolean update(Trade trade);

    void updateStatus(Long id, TradeStatus tradeStatus);

    List<Trade> getAll();

    Trade getById(Long id);

    List<Trade> getAllByStatus(TradeStatus tradeStatus);

    List<Trade> getAllByType(TradeType tradeType);

    List<Trade> getAllByTime(TradeTime tradeTime);
}
