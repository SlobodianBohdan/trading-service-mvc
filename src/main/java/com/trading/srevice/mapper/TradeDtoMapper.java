package com.trading.srevice.mapper;

import com.trading.srevice.dto.TradeDto;
import com.trading.srevice.model.Trade;
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
                .tradeType(trade.getTradeType())
                .tradeStatus(trade.getTradeStatus())
                .description(trade.getDescription())
                .mediaLinks(trade.getMediaLinks())
                .createdDate(trade.getCreatedDate())
                .updatedDate(trade.getUpdatedDate())
                .build();
    }
}
