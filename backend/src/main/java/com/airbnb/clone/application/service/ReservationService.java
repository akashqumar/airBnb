package com.airbnb.clone.application.service;

import com.airbnb.clone.application.dto.CreateReservationRequest;
import com.airbnb.clone.application.port.ListingRepositoryPort;
import com.airbnb.clone.application.port.NotificationPort;
import com.airbnb.clone.application.port.ReservationRepositoryPort;
import com.airbnb.clone.domain.model.Listing;
import com.airbnb.clone.domain.model.Reservation;
import com.airbnb.clone.domain.model.ReservationStatus;
import com.airbnb.clone.domain.service.PricingStrategy;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ReservationService {
    private final ListingRepositoryPort listingRepository;
    private final ReservationRepositoryPort reservationRepository;
    private final PricingStrategy pricingStrategy;
    private final NotificationPort notificationPort;

    public ReservationService(ListingRepositoryPort listingRepository,
                              ReservationRepositoryPort reservationRepository,
                              PricingStrategy pricingStrategy,
                              NotificationPort notificationPort) {
        this.listingRepository = listingRepository;
        this.reservationRepository = reservationRepository;
        this.pricingStrategy = pricingStrategy;
        this.notificationPort = notificationPort;
    }

    public Reservation create(CreateReservationRequest request) {
        Listing listing = listingRepository.findById(request.listingId())
                .orElseThrow(() -> new IllegalArgumentException("Listing not found"));

        Reservation reservation = new Reservation(
                UUID.randomUUID(),
                request.listingId(),
                request.guestId(),
                request.checkIn(),
                request.checkOut(),
                pricingStrategy.calculate(listing.nightlyRate(), request.checkIn(), request.checkOut()),
                ReservationStatus.CREATED
        );

        Reservation saved = reservationRepository.save(reservation);
        notificationPort.sendReservationCreated(saved);
        return saved;
    }
}
