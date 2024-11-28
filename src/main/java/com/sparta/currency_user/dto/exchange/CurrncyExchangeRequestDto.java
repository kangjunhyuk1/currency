package com.sparta.currency_user.dto.exchange;

import lombok.Getter;

@Getter
public class CurrncyExchangeRequestDto {

    private final Long beforeExchange;


    public CurrncyExchangeRequestDto(Long beforeExchange) {
        this.beforeExchange = beforeExchange;
    }
}
