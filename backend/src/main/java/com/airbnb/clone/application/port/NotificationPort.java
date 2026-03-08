package com.airbnb.clone.application.port;

import com.airbnb.clone.domain.model.Reservation;

public interface NotificationPort {
    void sendReservationCreated(Reservation reservation);
}
