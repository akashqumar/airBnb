package com.airbnb.clone.infrastructure.persistence.adapter;

import com.airbnb.clone.application.port.ReservationRepositoryPort;
import com.airbnb.clone.domain.model.Reservation;
import com.airbnb.clone.infrastructure.persistence.entity.ReservationEntity;
import com.airbnb.clone.infrastructure.persistence.repository.SpringDataReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReservationRepositoryAdapter implements ReservationRepositoryPort {
    private final SpringDataReservationRepository repository;

    @Override
    public Reservation save(Reservation reservation) {
        ReservationEntity entity = repository.save(toEntity(reservation));
        return toDomain(entity);
    }

    private ReservationEntity toEntity(Reservation reservation) {
        return ReservationEntity.builder()
                .id(reservation.id())
                .listingId(reservation.listingId())
                .guestId(reservation.guestId())
                .checkIn(reservation.checkIn())
                .checkOut(reservation.checkOut())
                .totalPrice(reservation.totalPrice())
                .status(reservation.status())
                .build();
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
