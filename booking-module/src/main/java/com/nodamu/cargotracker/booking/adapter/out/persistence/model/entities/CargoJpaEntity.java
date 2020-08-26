package com.nodamu.cargotracker.booking.adapter.out.persistence.model.entities;


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
