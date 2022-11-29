package com.in29minutes.microservices.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<Currency_Exchange,Long> {
    Currency_Exchange findByFromAndTo(String from, String to);
}
