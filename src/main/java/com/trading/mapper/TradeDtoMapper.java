package com.trading.mapper;

import com.trading.dto.PageDto;
import com.trading.dto.TradeDto;
import com.trading.model.Trade;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class TradeDtoMapper{

    public TradeDto toDto(Trade trade) {
        return TradeDto.builder()
                .id(trade.getId())
                .currencyPair(trade.getCurrencyPair())
                .buyPrice(trade.getBuyPrice())
                .stopLimit(trade.getStopLimit())
                .targets(trade.getTargets())
                .expectedResult(trade.getExpectedResult())
                .tradeType(trade.getTradeType())
                .tradeTime(trade.getTradeTime())
                .tradeStatus(trade.getTradeStatus())
                .description(trade.getDescription())
                .mediaLink(trade.getMediaLink())
                .createdDate(trade.getCreatedDate())
                .updatedDate(trade.getUpdatedDate())
                .build();
    }


    public Trade toEntity(TradeDto trade) {
        return Trade.builder()
                .id(trade.getId())
                .currencyPair(trade.getCurrencyPair())
                .buyPrice(trade.getBuyPrice())
                .stopLimit(trade.getStopLimit())
                .targets(trade.getTargets())
                .expectedResult(trade.getExpectedResult())
                .tradeType(trade.getTradeType())
                .tradeTime(trade.getTradeTime())
                .tradeStatus(trade.getTradeStatus())
                .description(trade.getDescription())
                .mediaLink(trade.getMediaLink())
                .createdDate(trade.getCreatedDate())
                .updatedDate(trade.getUpdatedDate())
                .build();
    }

    public PageDto toTradesPage(Page<Trade> tradesPage) {
        return PageDto.builder()
                .content(
                        tradesPage.getContent().stream()
                                .map(this::toDto).collect(Collectors.toList())
                )
                .currentPageNumber(tradesPage.getNumber() + 1)
                .totalPageNumber(tradesPage.getTotalPages())
                .hasNextPage(tradesPage.hasNext())
                .hasPreviousPage(tradesPage.hasPrevious())
                .build();

    }
}
