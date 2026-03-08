package com.airbnb.clone.application.service;

import com.airbnb.clone.application.dto.CreateListingRequest;
import com.airbnb.clone.application.port.ListingRepositoryPort;
import com.airbnb.clone.domain.model.Listing;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ListingService {
    private final ListingRepositoryPort listingRepository;

    public Listing create(CreateListingRequest request) {
        Listing listing = new Listing(
                UUID.randomUUID(),
                request.hostId(),
                request.title(),
                request.location(),
                request.nightlyRate(),
                request.maxGuests(),
                true
        );
        return listingRepository.save(listing);
    }

    public List<Listing> search(String location, Integer guests) {
        return listingRepository.search(location, guests);
    }
}
