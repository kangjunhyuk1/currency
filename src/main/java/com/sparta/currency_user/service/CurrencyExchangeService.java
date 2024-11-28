package com.sparta.currency_user.service;

import com.sparta.currency_user.repository.CurrencyExchangeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrencyExchangeService {

    private CurrencyExchangeRepository exchangeRepository;


}
