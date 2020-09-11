package com.nodamu.cargotracker.booking.adapter.out.persistence.model.mappers;

import com.nodamu.cargotracker.booking.adapter.out.persistence.model.entities.*;
import com.nodamu.cargotracker.booking.domain.aggregates.BookingId;
import com.nodamu.cargotracker.booking.domain.aggregates.Cargo;
import com.nodamu.cargotracker.booking.domain.entities.Location;
import com.nodamu.cargotracker.booking.domain.events.LastCargoHandledEvent;
import com.nodamu.cargotracker.booking.domain.valueobjects.BookingAmount;
import com.nodamu.cargotracker.booking.domain.valueobjects.RouteSpecification;
import com.nodamu.cargotracker.booking.domain.valueobjects.Voyage;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author profnick
 * 8/26/20
 **/
public class CargoMapper {

   public static Cargo mapToDomainEntity(CargoJpaEntity cargo){
        return new Cargo(
               new BookingId(cargo.getBookingId().getId()) ,
               new BookingAmount(cargo.getBookingAmount().getBookingAmount()) ,
               new RouteSpecification(
                        new Location(cargo.getRouteSpecification().getOrigin().getUnLocCode()),
                        new Location(cargo.getRouteSpecification().getDestination().getUnLocCode()),
                        cargo.getRouteSpecification().getArrivalDeadline()
                        )
        );

    }

    public static BookingIdJpa toJpaEntity(BookingId id){
       return new BookingIdJpa(id.getBookingId());
    }

    public static CargoJpaEntity toCargoJpaEntity(Cargo cargo){
//       return new CargoJpaEntity(
//               new BookingIdJpa(cargo.getId().getBookingId()),
//               new BookingAmountJpa(cargo.getBookingAmount().getBookingAmount()),
//               new RouteSpecificationJpa(
//                       new LocationJpa(cargo.getRouteSpecification().getOrigin().getUnLocCode()),
//                       new LocationJpa(cargo.getRouteSpecification().getDestination().getUnLocCode()),
//                       cargo.getRouteSpecification().getArrivalDeadline()
//               ),
//               DeliveryJpa.deriveFrom(cargo.getDelivery().getRoutingStatus(),
//                       cargo.getDelivery().getTransportStatus(),
//                       new LocationJpa(cargo.getDelivery().getLastKnownLocation().getUnLocCode()),
//                       cargo.getDelivery().getLastCargoHandledEvent()
//               )
        return new CargoJpaEntity.CargoJpaEntityBuilder(
                new BookingIdJpa(cargo.getId().getBookingId()),
                new BookingAmountJpa(cargo.getBookingAmount().getBookingAmount()),
                new LocationJpa(cargo.getRouteSpecification().getOrigin().getUnLocCode()))
                .setDelivery(DeliveryJpa.deriveFrom(cargo.getDelivery().getRoutingStatus(),
                       cargo.getDelivery().getTransportStatus(),
                       new LocationJpa(cargo.getDelivery().getLastKnownLocation().getUnLocCode()),
                       cargo.getDelivery().getLastCargoHandledEvent()))
                .setRouteSpecification(new RouteSpecificationJpa(
                       new LocationJpa(cargo.getRouteSpecification().getOrigin().getUnLocCode()),
                       new LocationJpa(cargo.getRouteSpecification().getDestination().getUnLocCode()),
                       cargo.getRouteSpecification().getArrivalDeadline()))
                .build();
    }

    //    Cargo domain aggregate to Jpa entity mapper with itinerary
    public static CargoJpaEntity toCargoJpaEntityWithItinerary(Cargo cargo){


        CargoJpaEntity.CargoJpaEntityBuilder cargoJpaEntityBuilder = new CargoJpaEntity.CargoJpaEntityBuilder(
                new BookingIdJpa(cargo.getId().getBookingId()),
                new BookingAmountJpa(cargo.getBookingAmount().getBookingAmount()),
                new LocationJpa(cargo.getRouteSpecification().getOrigin().getUnLocCode()));
        cargoJpaEntityBuilder.setDelivery(DeliveryJpa.deriveFrom(cargo.getDelivery().getRoutingStatus(),
                cargo.getDelivery().getTransportStatus(),
                new LocationJpa(cargo.getDelivery().getLastKnownLocation().getUnLocCode()),
                cargo.getDelivery().getLastCargoHandledEvent()));
        cargoJpaEntityBuilder.setRouteSpecification(new RouteSpecificationJpa(
                new LocationJpa(cargo.getRouteSpecification().getOrigin().getUnLocCode()),
                new LocationJpa(cargo.getRouteSpecification().getDestination().getUnLocCode()),
                cargo.getRouteSpecification().getArrivalDeadline()));
        cargoJpaEntityBuilder.setItinerary(new CargoItineraryJpa((List<LegJpa>) cargo.getItinerary().getLegs()
                .stream()
                .map(leg -> new LegJpa(
                        new VoyageJpa(leg.getVoyageNumber().getVoyageNumber()),
                        new LocationJpa(leg.getLoadLocation().getUnLocCode()),
                        new LocationJpa(leg.getUnLoadLocation().getUnLocCode()),
                        leg.getLoadTimeDate(),
                        leg.getUnLoadTimeDate()))
                .collect(Collectors.toList()))
        );
        return cargoJpaEntityBuilder
                .build();
    }




}
