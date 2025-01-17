package com.trading.tradingservice.service.impl;

import com.trading.tradingservice.exception.ServiceException;
import com.trading.tradingservice.model.Trade;
import com.trading.tradingservice.model.TradeStatus;
import com.trading.tradingservice.repository.TradeRepository;
import com.trading.tradingservice.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class TradeServiceImpl implements TradeService {

    private TradeRepository tradeRepository;

    private static final int PAGE_SIZE = 15;
    private static final Sort SORT = Sort.by("updatedDate").descending();

    @Autowired
    public TradeServiceImpl(TradeRepository tradeRepository) {
        this.tradeRepository = tradeRepository;
    }

    @Override
    public void create(Trade trade) {
        try {
            tradeRepository.save(trade);
        } catch (ServiceException e) {
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
    public void changeStatusFotTrade(Long tradeId, String result) {
        try {
            findByIdOrThrowException(tradeRepository, tradeId);
            Trade trade = tradeRepository.getById(tradeId).get();

            trade.setExpectedResult(result);
            trade.setTradeStatus(result.charAt(0) == '+' ?
                    TradeStatus.COMPLETED_PLUS : TradeStatus.COMPLETED_MINUS);
            tradeRepository.save(trade);
        } catch (ServiceException e) {
            throw new ServiceException("Not update trade status!");
        }
    }

    @Override
    public List<Trade> getAll() {
        try {
            return tradeRepository.findAll();
        } catch (Exception e) {
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
            throw new ServiceException("Trade with status " + tradeStatus + " not found!");
        }
    }

    @Override
    public Page<Trade> getAllWithArchive(int pageNumber) {
        try {
            Pageable pageable = createPageable(pageNumber);
            List<TradeStatus> tradeStatuses = Arrays.asList(TradeStatus.COMPLETED_PLUS,
                    TradeStatus.COMPLETED_MINUS);
            return tradeRepository.findAllByTradeStatusIn(tradeStatuses, pageable);
        } catch (Exception e) {
            throw new ServiceException("Trade in archive not found!");
        }
    }

    @Override
    public Page<Trade> findAllByCurrencyPairArchive(int pageNumber, String currencyPair) {
        try {
            Pageable pageable = createPageable(pageNumber);
            List<TradeStatus> tradeStatuses = Arrays.asList(TradeStatus.COMPLETED_PLUS,
                    TradeStatus.COMPLETED_MINUS);
            return tradeRepository.findAllByCurrencyPairAndTradeStatusIn(currencyPair.toUpperCase(), tradeStatuses, pageable);
        } catch (Exception e) {
            throw new ServiceException("Currency pair not found!");
        }
    }

    @Override
    public Page<Trade> findAllByCurrencyPairList(int pageNumber, String currencyPair) {
        try {
            Pageable pageable = createPageable(pageNumber);
            return tradeRepository.findAllByCurrencyPairAndTradeStatus(currencyPair.toUpperCase(), TradeStatus.ACTIVE, pageable);
        } catch (Exception e) {
            throw new ServiceException("Currency pair not found!");
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
