package com.trading.srevice.service.impl;

import com.trading.srevice.exception.ServiceException;
import com.trading.srevice.model.Trade;
import com.trading.srevice.model.TradeStatus;
import com.trading.srevice.repository.TradeRepository;
import com.trading.srevice.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public class TradeServiceImpl implements TradeService {

    private TradeRepository tradeRepository;

    @Autowired
    public TradeServiceImpl(TradeRepository tradeRepository) {
        this.tradeRepository = tradeRepository;
    }

    @Override
    public Trade create(Trade trade) {
        try {
            return tradeRepository.save(trade);
        }catch (Exception e){
            throw new ServiceException("Trade not created!");
        }
    }

    @Override
    public boolean update(Trade trade) {
        try {
            findByIdOrThrowException(tradeRepository, trade.getId());
            tradeRepository.save(trade);
            return true;
        } catch (ServiceException e) {
            return false;
        }
    }

    @Override
    public void updateStatus(Long id, TradeStatus tradeStatus) {
            Trade trade = tradeRepository.getById(id)
                    .orElseThrow(()->new ServiceException("Trade with isn't found!"));
            tradeRepository.save(trade);
    }

    @Override
    public List<Trade> getAll() {
        try {
            return tradeRepository.findAll();
        }catch (Exception e){
            throw new ServiceException("Trades not found!");
        }
    }

    @Override
    public Trade getById(Long id) {
        try {
            findByIdOrThrowException(tradeRepository, id);
            return tradeRepository.getById(id).get();
        } catch (ServiceException e) {
            throw new ServiceException("Trade not found!");
        }
    }

    @Override
    public List<Trade> getAllByStatus(TradeStatus tradeStatus) {
        try {
            return tradeRepository.getByTradeStatus(tradeStatus);
        } catch (Exception e) {
            throw new ServiceException("Trade with status " + tradeStatus + " not found!") ;
        }
    }

    private <T> T findByIdOrThrowException(JpaRepository<T, Long> repository, Long id) {
        return repository.findById(id).orElseThrow(() -> new ServiceException("Entity is not found!"));
    }

}
