package com.airbnb.clone.infrastructure.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "listings")
public class ListingEntity {
    @Id
    private UUID id;
    private UUID hostId;
    private String title;
    private String location;
    private BigDecimal nightlyRate;
    private Integer maxGuests;
    private boolean active;

    public ListingEntity() {
    }

    public ListingEntity(UUID id, UUID hostId, String title, String location, BigDecimal nightlyRate, Integer maxGuests, boolean active) {
        this.id = id;
        this.hostId = hostId;
        this.title = title;
        this.location = location;
        this.nightlyRate = nightlyRate;
        this.maxGuests = maxGuests;
        this.active = active;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getHostId() {
        return hostId;
    }

    public void setHostId(UUID hostId) {
        this.hostId = hostId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public BigDecimal getNightlyRate() {
        return nightlyRate;
    }

    public void setNightlyRate(BigDecimal nightlyRate) {
        this.nightlyRate = nightlyRate;
    }

    public Integer getMaxGuests() {
        return maxGuests;
    }

    public void setMaxGuests(Integer maxGuests) {
        this.maxGuests = maxGuests;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
