package com.sparta.currency_user.dto;

import lombok.Getter;

@Getter
public class CurrncyExchangeResponseDto {

    private final Long afterExchange;

    public CurrncyExchangeResponseDto(Long afterExchange) {
        this.afterExchange = afterExchange;
    }
}
