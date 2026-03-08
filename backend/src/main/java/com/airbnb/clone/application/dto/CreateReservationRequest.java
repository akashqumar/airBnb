package com.airbnb.clone.application.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public record CreateReservationRequest(
        @NotNull UUID listingId,
        @NotNull UUID guestId,
        @NotNull LocalDate checkIn,
        @NotNull LocalDate checkOut
) {}
