package com.sparta.currency_user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "currency")
@NoArgsConstructor
public class Currency extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long currencyId;

    private String currencyName;
    private BigDecimal exchangeRate;
    private String symbol;

    public Currency(String currencyName, BigDecimal exchangeRate, String symbol) {
        this.currencyName = currencyName;
        this.exchangeRate = exchangeRate;
        this.symbol = symbol;
    }

    @OneToMany(mappedBy = "currency")
    List<CurrencyExchange> currency = new ArrayList<>();
}
