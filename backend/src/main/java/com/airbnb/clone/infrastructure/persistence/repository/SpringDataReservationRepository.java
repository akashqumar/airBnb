package com.airbnb.clone.infrastructure.persistence.repository;

import com.airbnb.clone.infrastructure.persistence.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataReservationRepository extends JpaRepository<ReservationEntity, UUID> {
}
