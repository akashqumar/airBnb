package com.airbnb.clone.web;

import com.airbnb.clone.application.dto.CreateListingRequest;
import com.airbnb.clone.application.service.ListingService;
import com.airbnb.clone.domain.model.Listing;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/listings")
@RequiredArgsConstructor
public class ListingController {
    private final ListingService listingService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Listing create(@Valid @RequestBody CreateListingRequest request) {
        return listingService.create(request);
    }

    @GetMapping
    public List<Listing> search(@RequestParam(required = false) String location,
                                @RequestParam(required = false) Integer guests) {
        return listingService.search(location, guests);
    }
}
