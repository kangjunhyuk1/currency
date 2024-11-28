package com.sparta.currency_user.controller;

import com.sparta.currency_user.dto.currency.CurrencyResponseDto;
import com.sparta.currency_user.dto.exchange.CurrncyExchangeRequestDto;
import com.sparta.currency_user.service.CurrencyExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exchange")
@RequiredArgsConstructor
public class CurrncyExchangeControoler {

    private final CurrencyExchangeService exchangeService;

    @PostMapping
    public ResponseEntity<CurrencyResponseDto> CurrencyExchangeRequest(@RequestBody CurrncyExchangeRequestDto exchangeRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(exchangeService.createExchange(exchangeRequestDto));
    }

}
