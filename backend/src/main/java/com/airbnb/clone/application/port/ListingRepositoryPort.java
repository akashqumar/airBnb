package com.airbnb.clone.application.port;

import com.airbnb.clone.domain.model.Listing;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ListingRepositoryPort {
    Listing save(Listing listing);
    Optional<Listing> findById(UUID id);
    List<Listing> search(String location, Integer guests);
}
