package com.airbnb.clone.infrastructure.persistence.adapter;

import com.airbnb.clone.application.port.ReservationRepositoryPort;
import com.airbnb.clone.domain.model.Reservation;
import com.airbnb.clone.infrastructure.persistence.entity.ReservationEntity;
import com.airbnb.clone.infrastructure.persistence.repository.SpringDataReservationRepository;
import org.springframework.stereotype.Component;

@Component
public class ReservationRepositoryAdapter implements ReservationRepositoryPort {
    private final SpringDataReservationRepository repository;

    public ReservationRepositoryAdapter(SpringDataReservationRepository repository) {
        this.repository = repository;
    }

    @Override
    public Reservation save(Reservation reservation) {
        ReservationEntity entity = repository.save(toEntity(reservation));
        return toDomain(entity);
    }

    private ReservationEntity toEntity(Reservation reservation) {
        return new ReservationEntity(
                reservation.id(),
                reservation.listingId(),
                reservation.guestId(),
                reservation.checkIn(),
                reservation.checkOut(),
                reservation.totalPrice(),
                reservation.status()
        );
    }

    private Reservation toDomain(ReservationEntity entity) {
        return new Reservation(
                entity.getId(),
                entity.getListingId(),
                entity.getGuestId(),
                entity.getCheckIn(),
                entity.getCheckOut(),
                entity.getTotalPrice(),
                entity.getStatus());
    }
}
