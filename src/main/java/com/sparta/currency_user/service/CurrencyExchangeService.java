package com.sparta.currency_user.service;

import com.sparta.currency_user.dto.currency.CurrencyResponseDto;
import com.sparta.currency_user.dto.exchange.CurrncyExchangeRequestDto;
import com.sparta.currency_user.repository.CurrencyExchangeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrencyExchangeService {

    private CurrencyExchangeRepository exchangeRepository;


    public CurrencyResponseDto createExchange(CurrncyExchangeRequestDto exchangeRequestDto) {
        return null;
    }
}
