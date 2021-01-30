package com.trading.service;

import com.trading.model.TradeTime;
import com.trading.model.Trade;
import com.trading.model.TradeStatus;
import com.trading.model.TradeType;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TradeService {

    void create(Trade trade);

    void update(Trade trade);

    void updateStatus(Long id, TradeStatus tradeStatus);

    List<Trade> getAll();

    Trade getById(Long id);

    Page<Trade> getAllByStatus(int pageNumber, TradeStatus tradeStatus);

    List<Trade> getAllByType(TradeType tradeType);

    List<Trade> getAllByTime(TradeTime tradeTime);

    void deleteTradeById(Long id);
}
