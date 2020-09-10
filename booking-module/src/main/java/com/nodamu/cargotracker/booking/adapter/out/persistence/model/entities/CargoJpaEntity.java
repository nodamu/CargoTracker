package com.nodamu.cargotracker.booking.adapter.out.persistence.model.entities;




import com.nodamu.cargotracker.shareddomain.events.CargoBookedEvent;
import com.nodamu.cargotracker.shareddomain.events.CargoBookedEventData;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author profnick
 * 8/22/20
 **/

@Entity
@Table(name = "Cargo")
public class CargoJpaEntity  extends AbstractAggregateRoot <CargoJpaEntity> {

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

    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;

    @CreationTimestamp
    private LocalDateTime createdDate;

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

        /**
         * Register cargo created event
         */
        addDomainEvent(new CargoBookedEvent(new CargoBookedEventData(bookingId.getId())));

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

    public void addDomainEvent(Object event){
        registerEvent(event);
    }
}
