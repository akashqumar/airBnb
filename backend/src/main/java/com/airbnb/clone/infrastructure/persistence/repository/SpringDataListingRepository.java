package com.airbnb.clone.infrastructure.persistence.repository;

import com.airbnb.clone.infrastructure.persistence.entity.ListingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SpringDataListingRepository extends JpaRepository<ListingEntity, UUID> {
    List<ListingEntity> findByActiveTrueAndLocationContainingIgnoreCaseAndMaxGuestsGreaterThanEqual(String location, Integer guests);
}
