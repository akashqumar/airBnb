package com.airbnb.clone.web;

import com.airbnb.clone.application.dto.CreateReservationRequest;
import com.airbnb.clone.application.service.ReservationService;
import com.airbnb.clone.domain.model.Reservation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/reservations")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation create(@Valid @RequestBody CreateReservationRequest request) {
        return reservationService.create(request);
    }
}
