package com.trading.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
//    @Column(unique = true)
    private String currencyPair;
    @Enumerated(EnumType.STRING)
    private TradeType tradeType;
    @Enumerated(EnumType.STRING)
    private TradeStatus tradeStatus;
    @Enumerated(EnumType.STRING)
    private TradeTime tradeTime;
    private String description;
    @Column(columnDefinition="text")
    private String mediaLinks;
    @CreationTimestamp
    private Timestamp createdDate;
    @UpdateTimestamp
    private Timestamp updatedDate;


}
