package com.nodamu.cargotracker.booking.adapter.out.persistence.model.entities;



import com.nodamu.cargotracker.shareddomain.events.CargoBookedEvent;
import com.nodamu.cargotracker.shareddomain.events.CargoBookedEventData;
import com.nodamu.cargotracker.shareddomain.events.CargoRoutedEvent;
import com.nodamu.cargotracker.shareddomain.events.CargoRoutedEventData;
import lombok.Setter;
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

    public CargoJpaEntity() { }


    /**
     * Static builder pattern for constructing CargoJpaEntity
     */
    public static class CargoJpaEntityBuilder{
        private BookingIdJpa bookingId;
        private BookingAmountJpa bookingAmount;
        private LocationJpa origin;
        private RouteSpecificationJpa routeSpecification;
        private CargoItineraryJpa itinerary;
        private DeliveryJpa delivery;

        public CargoJpaEntityBuilder(BookingIdJpa bookingId, BookingAmountJpa bookingAmount, LocationJpa origin) {
            this.bookingId = bookingId;
            this.bookingAmount = bookingAmount;
            this.origin = origin;
            this.itinerary = CargoItineraryJpa.EMPTY_ITINERARY;
        }


        public CargoJpaEntityBuilder setRouteSpecification(RouteSpecificationJpa routeSpecification) {
            this.routeSpecification = routeSpecification;
            return this;
        }

        public CargoJpaEntityBuilder setItinerary(CargoItineraryJpa itinerary) {
            this.itinerary = itinerary;
            return this;
        }

        public CargoJpaEntityBuilder setDelivery(DeliveryJpa delivery) {
            this.delivery = delivery;
            return this;
        }

        public CargoJpaEntity build(){
            return new CargoJpaEntity(this);
        }
    }

    public CargoJpaEntity(CargoJpaEntityBuilder builder) {
        this.bookingId = builder.bookingId;
        this.bookingAmount = builder.bookingAmount;
        this.routeSpecification = builder.routeSpecification;
        this.origin = routeSpecification.getOrigin();
        this.itinerary = builder.itinerary;
        this.delivery = builder.delivery;

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

    public CargoItineraryJpa getItinerary() {
        return itinerary;
    }

    public void addDomainEvent(Object event){
        registerEvent(event);
    }

    public void setBookingId(BookingIdJpa bookingId) {
        this.bookingId = bookingId;
    }

    public void setBookingAmount(BookingAmountJpa bookingAmount) {
        this.bookingAmount = bookingAmount;
    }

    public void setOrigin(LocationJpa origin) {
        this.origin = origin;
    }

    public void setRouteSpecification(RouteSpecificationJpa routeSpecification) {
        this.routeSpecification = routeSpecification;
    }

    public void setItinerary(CargoItineraryJpa itinerary) {
        this.itinerary = itinerary;
    }

    public void setDelivery(DeliveryJpa delivery) {
        this.delivery = delivery;
        addDomainEvent(new CargoRoutedEvent(new CargoRoutedEventData(this.getBookingId().getId())));
    }

}
