package com.trading.mapper;

import com.trading.dto.TradeDto;
import com.trading.model.Trade;
import org.springframework.stereotype.Component;

@Component
public class TradeDtoMapper{

    public TradeDto toDto(Trade trade) {
        return TradeDto.builder()
                .id(trade.getId())
                .currencyPair(trade.getCurrencyPair())
                .buyPrice(trade.getBuyPrice())
                .stopLimit(trade.getStopLimit())
                .targets(trade.getTargets())
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
                .tradeType(trade.getTradeType())
                .tradeTime(trade.getTradeTime())
                .tradeStatus(trade.getTradeStatus())
                .description(trade.getDescription())
                .mediaLink(trade.getMediaLink())
                .createdDate(trade.getCreatedDate())
                .updatedDate(trade.getUpdatedDate())
                .build();
    }
}
