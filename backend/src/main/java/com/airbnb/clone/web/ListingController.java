package com.airbnb.clone.web;

import com.airbnb.clone.application.dto.CreateListingRequest;
import com.airbnb.clone.application.service.ListingService;
import com.airbnb.clone.domain.model.Listing;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/listings")
public class ListingController {
    private final ListingService listingService;

    public ListingController(ListingService listingService) {
        this.listingService = listingService;
    }

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
