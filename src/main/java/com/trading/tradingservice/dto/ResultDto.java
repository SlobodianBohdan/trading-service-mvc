package com.trading.tradingservice.dto;


import lombok.*;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ResultDto {

    @NotBlank(message = "Created cannot be empty")
    private String expectedResult;

}
