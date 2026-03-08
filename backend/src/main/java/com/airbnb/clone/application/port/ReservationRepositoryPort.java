package com.airbnb.clone.application.port;

import com.airbnb.clone.domain.model.Reservation;

public interface ReservationRepositoryPort {
    Reservation save(Reservation reservation);
}
