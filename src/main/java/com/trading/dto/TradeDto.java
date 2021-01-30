package com.trading.dto;


import com.trading.model.TradeStatus;
import com.trading.model.TradeTime;
import com.trading.model.TradeType;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
    @NotBlank(message = "Created cannot be empty")
    private TradeType tradeType;
    @NotBlank(message = "Created cannot be empty")
    private TradeStatus tradeStatus;
    @NotBlank(message = "Created cannot be empty")
    private TradeTime tradeTime;
    @NotBlank(message = "Created cannot be empty")
    private String description;
    @NotBlank(message = "Created cannot be empty")
    private String mediaLink;

    private Timestamp createdDate;
    private Timestamp updatedDate;
}
