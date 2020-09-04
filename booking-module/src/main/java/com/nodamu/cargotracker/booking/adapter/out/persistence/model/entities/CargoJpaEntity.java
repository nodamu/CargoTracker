package com.nodamu.cargotracker.booking.adapter.out.persistence.model.entities;


import com.nodamu.cargotracker.booking.domain.aggregates.BookingId;
import com.nodamu.cargotracker.booking.domain.entities.Location;
import com.nodamu.cargotracker.booking.domain.events.LastCargoHandledEvent;
import com.nodamu.cargotracker.booking.domain.valueobjects.BookingAmount;
import com.nodamu.cargotracker.booking.domain.valueobjects.CargoItinerary;
import com.nodamu.cargotracker.booking.domain.valueobjects.Delivery;
import com.nodamu.cargotracker.booking.domain.valueobjects.RouteSpecification;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;

/**
 * @author profnick
 * 8/22/20
 **/

@Entity
@Table(name = "Cargo")
public class CargoJpaEntity {
    /**
     * TODO
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private BookingIdJpa bookingId;

    @Embedded
    private BookingAmountJpa bookingAmount;

    @Embedded
    private LocationJpa origin;

    @Embedded
    private RouteSpecificationJpa routeSpecification;

    @Embedded
    private CargoItineraryJpa itinerary;

    @Embedded
    private DeliveryJpa delivery;

    protected CargoJpaEntity() { }

    public void setId(Long id) {
        this.id = id;
    }

    public CargoJpaEntity(BookingIdJpa bookingId, BookingAmountJpa bookingAmount, RouteSpecificationJpa routeSpecification, DeliveryJpa delivery) {
        this.bookingId = bookingId;
        this.bookingAmount = bookingAmount;
        this.routeSpecification = routeSpecification;
        this.origin = routeSpecification.getOrigin();
        this.itinerary = CargoItineraryJpa.EMPTY_ITINERARY;
        this.delivery = delivery;
    }


    public Long getId() {
        return id;
    }

    public BookingIdJpa getBookingId() {
        return bookingId;
    }

    public BookingAmountJpa getBookingAmount() {
        return bookingAmount;
    }

    public LocationJpa getOrigin() {
        return origin;
    }

    public RouteSpecificationJpa getRouteSpecification() {
        return routeSpecification;
    }

    public void setBookingAmount(BookingAmountJpa bookingAmount) {
        this.bookingAmount = bookingAmount;
    }

    public void setOrigin(LocationJpa origin) {
        this.origin = origin;
    }
}
