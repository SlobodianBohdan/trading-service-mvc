package com.trading.srevice.service;

import com.trading.srevice.model.Trade;
import com.trading.srevice.model.TradeStatus;
import com.trading.srevice.model.TradeTime;
import com.trading.srevice.model.TradeType;

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
