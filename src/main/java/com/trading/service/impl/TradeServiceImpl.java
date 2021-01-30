package com.trading.service.impl;

import com.trading.repository.TradeRepository;
import com.trading.exception.ServiceException;
import com.trading.model.Trade;
import com.trading.model.TradeStatus;
import com.trading.model.TradeTime;
import com.trading.model.TradeType;
import com.trading.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TradeServiceImpl implements TradeService {

    private TradeRepository tradeRepository;

    private static final int PAGE_SIZE = 3;
    private static final Sort SORT = Sort.by("updatedDate").descending();

    @Autowired
    public TradeServiceImpl(TradeRepository tradeRepository) {
        this.tradeRepository = tradeRepository;
    }

    @Override
    public void create(Trade trade) {
        try {
            tradeRepository.save(trade);
        }catch (Exception e){
            throw new ServiceException("Trade not created!");
        }
    }

    @Override
    public void update(Trade trade) {
        try {
            findByIdOrThrowException(tradeRepository, trade.getId());

            Trade tradeUpdate = tradeRepository.getById(trade.getId()).get();
            tradeUpdate.setId(trade.getId());
            tradeUpdate.setCurrencyPair(trade.getCurrencyPair());
            tradeUpdate.setBuyPrice(trade.getBuyPrice());
            tradeUpdate.setStopLimit(trade.getStopLimit());
            tradeUpdate.setTargets(trade.getTargets());
            tradeUpdate.setExpectedResult(trade.getExpectedResult());
            tradeUpdate.setTradeType(trade.getTradeType());
            tradeUpdate.setTradeTime(trade.getTradeTime());
            tradeUpdate.setTradeStatus(trade.getTradeStatus());
            tradeUpdate.setDescription(trade.getDescription());
            tradeUpdate.setMediaLink(trade.getMediaLink());
            tradeUpdate.setUpdatedDate(Timestamp.valueOf(LocalDateTime.now()));
            tradeRepository.save(tradeUpdate);

        } catch (ServiceException e) {
            throw new ServiceException("Trades not update!");
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
    public Page<Trade> getAllByStatus(int pageNumber, TradeStatus tradeStatus) {
        try {
            Pageable pageable = createPageable(pageNumber);
            return tradeRepository.findAllByTradeStatus(tradeStatus, pageable);
        } catch (Exception e) {
            throw new ServiceException("Trade with status " + tradeStatus + " not found!") ;
        }
    }

    @Override
    public List<Trade> getAllByType(TradeType tradeType) {
        try {
            return tradeRepository.getByTradeType(tradeType);
        } catch (Exception e) {
            throw new ServiceException("Trade with status " + tradeType + " not found!") ;
        }
    }

    @Override
    public List<Trade> getAllByTime(TradeTime tradeTime) {
        try {
            return tradeRepository.getByTradeTime(tradeTime);
        } catch (Exception e) {
            throw new ServiceException("Trade with status " + tradeTime + " not found!") ;
        }
    }

    @Override
    public void deleteTradeById(Long id) {
        try {
            findByIdOrThrowException(tradeRepository, id);
            tradeRepository.deleteById(id);
        } catch (ServiceException e) {
            throw new ServiceException("Trade not delete!");
        }
    }

    private Pageable createPageable(int pageNumber) {

        if (pageNumber < 1) {
            throw new ServiceException("Incorrect page number!");
        }

        return PageRequest.of(pageNumber - 1, PAGE_SIZE, SORT);
    }

    private <T> T findByIdOrThrowException(JpaRepository<T, Long> repository, Long id) {
        return repository.findById(id).orElseThrow(() -> new ServiceException("Entity is not found!"));
    }
}
