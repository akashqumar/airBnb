package com.airbnb.clone.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record Reservation(
        UUID id,
        UUID listingId,
        UUID guestId,
        LocalDate checkIn,
        LocalDate checkOut,
        BigDecimal totalPrice,
        ReservationStatus status
) {}
