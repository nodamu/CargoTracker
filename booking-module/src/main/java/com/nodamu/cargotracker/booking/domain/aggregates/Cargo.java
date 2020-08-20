package com.nodamu.cargotracker.booking.domain.aggregates;

import com.nodamu.cargotracker.booking.domain.entities.Location;
import com.nodamu.cargotracker.booking.domain.valueobjects.BookingAmount;
import com.nodamu.cargotracker.booking.domain.valueobjects.CargoItinerary;
import com.nodamu.cargotracker.booking.domain.valueobjects.Delivery;
import com.nodamu.cargotracker.booking.domain.valueobjects.RouteSpecification;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

/**
 * @author profnick
 * 8/20/20
 **/

@AllArgsConstructor
@Getter
public class Cargo {
    private CargoId cargoId;
    private BookingAmount bookingAmount;
    private Location origin;
    private RouteSpecification routeSpecification;
    private CargoItinerary itinerary;
    private Delivery delivery;



    @Value
    public static class CargoId{
        private String id;
    }
}
