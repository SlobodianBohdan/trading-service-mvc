package com.trading.srevice.service;

import com.trading.srevice.model.Trade;
import com.trading.srevice.model.TradeStatus;

import java.util.List;

public interface TradeService {

    boolean create(Trade trade);

    boolean update(Trade trade);

    void updateStatus(Long id, TradeStatus tradeStatus);

    List<Trade> getAll();

    Trade getById(Long id);
}
