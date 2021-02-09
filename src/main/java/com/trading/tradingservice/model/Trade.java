package com.trading.tradingservice.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.sql.Timestamp;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
@Table(name = "trades")
public class Trade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String currencyPair;
    @NonNull
    private String buyPrice;
    @NonNull
    private String stopLimit;
    @NonNull
    private String targets;
    @NonNull
    private String expectedResult;
    @Enumerated(EnumType.STRING)
    private TradeType tradeType;
    @Enumerated(EnumType.STRING)
    private TradeStatus tradeStatus;
    @Enumerated(EnumType.STRING)
    private TradeTime tradeTime;
    @NonNull
    @Column(columnDefinition="TEXT")
    private String description;
    @Column(columnDefinition="text")
    private String mediaLink;
    @CreationTimestamp
    private Timestamp createdDate;
    @UpdateTimestamp
    private Timestamp updatedDate;


}
