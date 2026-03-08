package com.airbnb.clone.domain.model;

import java.math.BigDecimal;
import java.util.UUID;

public record Listing(
        UUID id,
        UUID hostId,
        String title,
        String location,
        BigDecimal nightlyRate,
        int maxGuests,
        boolean active
) {}
