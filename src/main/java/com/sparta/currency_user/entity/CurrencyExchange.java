package com.sparta.currency_user.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class CurrencyExchange extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long currencyExchangeId;

    @Column(nullable = false)
    private Long beforeExchange;

    @Column(nullable = false)
    private Long afterExchange;

    private String status = "Y";

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "currency_id", nullable = false)
    private Currency currency;
}
