package com.nodamu.cargotracker.booking.domain.valueobjects;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author profnick
 * 8/20/20
 **/

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CargoItinerary {
    public static final CargoItinerary EMPTY_ITINERARY = new CargoItinerary();
    private List<Leg> legs;

}
