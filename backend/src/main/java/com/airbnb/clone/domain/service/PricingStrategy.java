package com.airbnb.clone.domain.service;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface PricingStrategy {
    BigDecimal calculate(BigDecimal nightlyRate, LocalDate checkIn, LocalDate checkOut);
}
