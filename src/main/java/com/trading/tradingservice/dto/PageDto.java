package com.trading.tradingservice.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PageDto<T> {

    private List<T> content;

    private int currentPageNumber;

    private int totalPageNumber;

    private boolean hasNextPage;

    private boolean hasPreviousPage;

}
