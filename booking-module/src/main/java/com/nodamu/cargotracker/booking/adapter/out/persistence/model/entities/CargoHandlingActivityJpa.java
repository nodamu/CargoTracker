package com.nodamu.cargotracker.booking.adapter.out.persistence.model.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

/**
 * @author profnick
 * 8/25/20
 **/

@Embeddable
public class CargoHandlingActivityJpa {
    @Column(name = "next_expected_handling_event_type")
    private String type;

    @Embedded
    @AttributeOverride(name = "unLocCode", column = @Column(name = "next_expected_location_id"))
    private LocationJpa location;

    @Column(name = "next_expected_voyage_id")
    private VoyageJpa voyage;

    public CargoHandlingActivityJpa() {
    }

    public CargoHandlingActivityJpa(String type, LocationJpa location) {
        this.type = type;
        this.location = location;
    }

    public CargoHandlingActivityJpa(String type, LocationJpa location, VoyageJpa voyage) {
        this.type = type;
        this.location = location;
        this.voyage = voyage;
    }
}
