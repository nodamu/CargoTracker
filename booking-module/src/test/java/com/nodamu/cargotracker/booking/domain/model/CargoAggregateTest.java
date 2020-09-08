package com.nodamu.cargotracker.booking.domain.model;

import com.nodamu.cargotracker.booking.domain.aggregates.BookingId;
import com.nodamu.cargotracker.booking.domain.aggregates.Cargo;
import com.nodamu.cargotracker.booking.domain.entities.Location;
import com.nodamu.cargotracker.booking.domain.valueobjects.BookingAmount;
import com.nodamu.cargotracker.booking.domain.valueobjects.RouteSpecification;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 * @author profnick
 * 8/24/20
 **/


public class CargoAggregateTest {

    /*
     *  TODO - Write tests for Cargo aggregate
     */
    @Test
    void  create_cargo_booking(){
        Cargo cargo = new Cargo(
                new BookingId("GRACE"),
                new BookingAmount(12),
                new RouteSpecification(
                        new Location("NGR"),
                        new Location("GHA"),
                        new Date(2020,9,7)
                )
        );


    }
}
