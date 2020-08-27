package com.nodamu.cargotracker.booking.domain.aggregates;

import com.nodamu.cargotracker.booking.domain.entities.Location;
import com.nodamu.cargotracker.booking.domain.events.LastCargoHandledEvent;
import com.nodamu.cargotracker.booking.domain.valueobjects.BookingAmount;
import com.nodamu.cargotracker.booking.domain.valueobjects.CargoItinerary;
import com.nodamu.cargotracker.booking.domain.valueobjects.Delivery;
import com.nodamu.cargotracker.booking.domain.valueobjects.RouteSpecification;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author profnick
 * 8/21/20
 **/


public class Cargo {
    @Getter private BookingId id;
    @Getter @Setter private BookingAmount bookingAmount;
    @Getter @Setter private Location origin;
    @Getter private RouteSpecification routeSpecification;
    @Getter private CargoItinerary itinerary;
    @Getter private Delivery delivery;

    public Cargo(BookingId id,
                 BookingAmount bookingAmount,
                 RouteSpecification routeSpecification
                 ) {
        this.id = id;
        this.bookingAmount = bookingAmount;
        this.routeSpecification = routeSpecification;
        this.origin = routeSpecification.getOrigin();
        this.itinerary = CargoItinerary.EMPTY_ITINERARY;
        this.delivery = Delivery.derivedFrom(this.routeSpecification,this.itinerary,LastCargoHandledEvent.EMPTY);
    }

    /**
     * Derives delivery progress from lastCargoHandledEvent
     * @param lastCargoHandledEvent
     */
    public void deriveDeliveryProgress(LastCargoHandledEvent lastCargoHandledEvent){
        this.delivery = Delivery.derivedFrom(getRouteSpecification(), getItinerary(),lastCargoHandledEvent);
    }


}
