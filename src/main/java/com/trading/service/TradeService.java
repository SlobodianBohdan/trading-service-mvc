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

    void changeStatusFotTrade(Long id, String result);

    List<Trade> getAll();

    Trade getById(Long id);

    Page<Trade> getAllByStatus(int pageNumber, TradeStatus tradeStatus);

    Page<Trade> getAllWithArchive(int pageNumber);

    Page<Trade> findAllByCurrencyPairArchive(int pageNumber, String currencyPair);

    Page<Trade> findAllByCurrencyPairList(int pageNumber, String currencyPair);

    void deleteTradeById(Long id);
}
