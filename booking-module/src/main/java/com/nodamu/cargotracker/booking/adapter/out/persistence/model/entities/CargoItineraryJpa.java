package com.nodamu.cargotracker.booking.adapter.out.persistence.model.entities;

import com.nodamu.cargotracker.booking.domain.valueobjects.CargoItinerary;
import com.nodamu.cargotracker.booking.domain.valueobjects.Leg;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

/**
 * @author profnick
 * 8/25/20
 **/

@Embeddable
public class CargoItineraryJpa {

    /**
     * TODO - Add JPA annotations to class
     */
    public static final CargoItineraryJpa EMPTY_ITINERARY = new CargoItineraryJpa();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cargo_id")
    @OrderBy("loadTime")
    private List<LegJpa> legs = Collections.emptyList();

    public CargoItineraryJpa(List<LegJpa> legs) {
        this.legs = legs;
    }

    public CargoItineraryJpa() {
    }

    /**
     * We don't want to change a Cargo's Itinerary once it has been set
     * @return
     */
    public List<LegJpa> getLegs() {
        return Collections.unmodifiableList(legs);
    }
}
