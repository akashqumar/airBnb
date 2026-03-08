package com.airbnb.clone.infrastructure.persistence.adapter;

import com.airbnb.clone.application.port.ListingRepositoryPort;
import com.airbnb.clone.domain.model.Listing;
import com.airbnb.clone.infrastructure.persistence.entity.ListingEntity;
import com.airbnb.clone.infrastructure.persistence.repository.SpringDataListingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ListingRepositoryAdapter implements ListingRepositoryPort {
    private final SpringDataListingRepository repository;

    @Override
    public Listing save(Listing listing) {
        return toDomain(repository.save(toEntity(listing)));
    }

    @Override
    public Optional<Listing> findById(UUID id) {
        return repository.findById(id).map(this::toDomain);
    }

    @Override
    public List<Listing> search(String location, Integer guests) {
        String normalizedLocation = location == null ? "" : location;
        Integer normalizedGuests = guests == null ? 1 : guests;

        return repository.findByActiveTrueAndLocationContainingIgnoreCaseAndMaxGuestsGreaterThanEqual(
                        normalizedLocation,
                        normalizedGuests)
                .stream()
                .map(this::toDomain)
                .toList();
    }

    private ListingEntity toEntity(Listing listing) {
        return ListingEntity.builder()
                .id(listing.id())
                .hostId(listing.hostId())
                .title(listing.title())
                .location(listing.location())
                .nightlyRate(listing.nightlyRate())
                .maxGuests(listing.maxGuests())
                .active(listing.active())
                .build();
    }

    private Listing toDomain(ListingEntity entity) {
        return new Listing(
                entity.getId(),
                entity.getHostId(),
                entity.getTitle(),
                entity.getLocation(),
                entity.getNightlyRate(),
                entity.getMaxGuests(),
                entity.isActive());
    }
}
