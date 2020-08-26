package com.nodamu.cargotracker.booking.adapter.out.persistence.model.mappers;

import com.nodamu.cargotracker.booking.adapter.out.persistence.model.entities.BookingIdJpa;
import com.nodamu.cargotracker.booking.adapter.out.persistence.model.entities.CargoJpaEntity;
import com.nodamu.cargotracker.booking.domain.aggregates.BookingId;
import com.nodamu.cargotracker.booking.domain.aggregates.Cargo;
import com.nodamu.cargotracker.booking.domain.entities.Location;
import com.nodamu.cargotracker.booking.domain.valueobjects.BookingAmount;
import com.nodamu.cargotracker.booking.domain.valueobjects.RouteSpecification;

/**
 * @author profnick
 * 8/26/20
 **/
public class CargoMapper {

   public static Cargo mapToDomainEntity(CargoJpaEntity cargo){
        return  new Cargo(
               new BookingId(cargo.getBookingId().getId()) ,
               new BookingAmount(cargo.getBookingAmount().getBookingAmount()) ,
                new Location(cargo.getOrigin().getUnLocCode()),
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


}
