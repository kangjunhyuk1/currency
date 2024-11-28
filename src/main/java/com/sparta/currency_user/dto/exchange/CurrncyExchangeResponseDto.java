package com.sparta.currency_user.dto.exchange;

import lombok.Getter;

@Getter
public class CurrncyExchangeResponseDto {

    private final Long afterExchange;

    public CurrncyExchangeResponseDto(Long afterExchange) {
        this.afterExchange = afterExchange;
    }
}
