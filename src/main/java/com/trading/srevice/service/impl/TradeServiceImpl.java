package com.trading.srevice.service.impl;

import com.trading.srevice.model.Trade;
import com.trading.srevice.model.TradeStatus;
import com.trading.srevice.repository.TradeRepository;
import com.trading.srevice.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TradeServiceImpl implements TradeService {

    private TradeRepository tradeRepository;

    @Autowired
    public TradeServiceImpl(TradeRepository tradeRepository) {
        this.tradeRepository = tradeRepository;
    }

    @Override
    public boolean create(Trade trade) {
        return true;
    }

    @Override
    public boolean update(Trade trade) {
        return true;
    }

    @Override
    public void updateStatus(Long id, TradeStatus tradeStatus) {

    }

    @Override
    public List<Trade> getAll() {
        return null;
    }

    @Override
    public Trade getById(Long id) {
        return tradeRepository.getById(id);
    }

}
