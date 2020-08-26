package com.nodamu.cargotracker.booking.domain.valueobjects;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

/**
 * @author profnick
 * 8/21/20
 **/

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CargoItinerary {
    public static final CargoItinerary EMPTY_ITINERARY = new CargoItinerary();
    private List<Leg> legs = Collections.emptyList();

    public CargoItinerary(List<Leg> legs) {
        this.legs = legs;
    }

    /**
     * We don't want to change a Cargo's Itinerary once it has been set
     * @return
     */
    public List<Leg> getLegs() {
        return Collections.unmodifiableList(legs);
    }
}
