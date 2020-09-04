package com.nodamu.cargotracker.booking.adapter.out.persistence.model.mappers;

import com.nodamu.cargotracker.booking.adapter.out.persistence.model.entities.*;
import com.nodamu.cargotracker.booking.domain.aggregates.BookingId;
import com.nodamu.cargotracker.booking.domain.aggregates.Cargo;
import com.nodamu.cargotracker.booking.domain.entities.Location;
import com.nodamu.cargotracker.booking.domain.events.LastCargoHandledEvent;
import com.nodamu.cargotracker.booking.domain.valueobjects.BookingAmount;
import com.nodamu.cargotracker.booking.domain.valueobjects.RouteSpecification;
import com.nodamu.cargotracker.booking.domain.valueobjects.Voyage;

/**
 * @author profnick
 * 8/26/20
 **/
public class CargoMapper {

   public static Cargo mapToDomainEntity(CargoJpaEntity cargo){
        return  new Cargo(
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
       return new CargoJpaEntity(
               new BookingIdJpa(cargo.getId().toString()),
               new BookingAmountJpa(cargo.getBookingAmount().getBookingAmount()),
               new RouteSpecificationJpa(
                       new LocationJpa(cargo.getRouteSpecification().getOrigin().getUnLocCode()),
                       new LocationJpa(cargo.getRouteSpecification().getDestination().getUnLocCode()),
                       cargo.getRouteSpecification().getArrivalDeadline()
               ),
               DeliveryJpa.deriveFrom(cargo.getDelivery().getRoutingStatus(),
                       cargo.getDelivery().getTransportStatus(),
                       new LocationJpa(cargo.getDelivery().getLastKnownLocation().getUnLocCode()),
                       cargo.getDelivery().getLastCargoHandledEvent()
               )

       );
    }


}
