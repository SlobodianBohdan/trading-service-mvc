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
                .tradeType(trade.getTradeType())
                .tradeType(trade.getTradeType())
                .tradeStatus(trade.getTradeStatus())
                .description(trade.getDescription())
                .mediaLinks(trade.getMediaLinks())
                .createdDate(trade.getCreatedDate())
                .updatedDate(trade.getUpdatedDate())
                .build();
    }


    public Trade toEntity(TradeDto trade) {
        return Trade.builder()
                .id(trade.getId())
                .currencyPair(trade.getCurrencyPair())
                .tradeType(trade.getTradeType())
                .tradeTime(trade.getTradeTime())
                .tradeStatus(trade.getTradeStatus())
                .description(trade.getDescription())
                .mediaLinks(trade.getMediaLinks())
                .createdDate(trade.getCreatedDate())
                .updatedDate(trade.getUpdatedDate())
                .build();
    }
}
