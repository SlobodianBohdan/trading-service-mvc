package com.trading.tradingservice.dto;


import com.trading.tradingservice.model.TradeStatus;
import com.trading.tradingservice.model.TradeTime;
import com.trading.tradingservice.model.TradeType;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class TradeDto {

    private Long id;
    @NotBlank(message = "Created cannot be empty")
    private String currencyPair;
    @NotBlank(message = "Created cannot be empty")
    private String buyPrice;
    @NotBlank(message = "Created cannot be empty")
    private String stopLimit;
    @NotBlank(message = "Created cannot be empty")
    private String targets;
    @NotBlank(message = "Created cannot be empty")
    private String expectedResult;
    @NotNull
    private TradeType tradeType;

    private TradeStatus tradeStatus;
    @NotNull
    private TradeTime tradeTime;
    @NotBlank(message = "Created cannot be empty")
    private String description;
    @NotBlank(message = "Created cannot be empty")
    private String mediaLink;

    private Timestamp createdDate;
    private Timestamp updatedDate;
}
