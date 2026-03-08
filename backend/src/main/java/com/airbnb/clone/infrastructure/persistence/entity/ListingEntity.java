package com.airbnb.clone.infrastructure.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "listings")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ListingEntity {
    @Id
    private UUID id;
    private UUID hostId;
    private String title;
    private String location;
    private BigDecimal nightlyRate;
    private Integer maxGuests;
    private boolean active;
}
