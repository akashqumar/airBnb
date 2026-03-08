package com.airbnb.clone.domain.service;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Component
public class DefaultPricingStrategy implements PricingStrategy {
    @Override
    public BigDecimal calculate(BigDecimal nightlyRate, LocalDate checkIn, LocalDate checkOut) {
        long nights = ChronoUnit.DAYS.between(checkIn, checkOut);
        if (nights <= 0) {
            throw new IllegalArgumentException("Check-out must be after check-in");
        }
        BigDecimal subtotal = nightlyRate.multiply(BigDecimal.valueOf(nights));
        BigDecimal serviceFee = subtotal.multiply(BigDecimal.valueOf(0.12));
        return subtotal.add(serviceFee).setScale(2, RoundingMode.HALF_UP);
    }
}
