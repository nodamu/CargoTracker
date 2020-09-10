package com.nodamu.cargotracker.booking.domain.model;

import com.nodamu.cargotracker.booking.domain.aggregates.BookingId;
import com.nodamu.cargotracker.booking.domain.aggregates.Cargo;
import com.nodamu.cargotracker.booking.domain.entities.Location;
import com.nodamu.cargotracker.booking.domain.events.LastCargoHandledEvent;
import com.nodamu.cargotracker.booking.domain.valueobjects.BookingAmount;
import com.nodamu.cargotracker.booking.domain.valueobjects.RouteSpecification;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

/**
 * @author profnick
 * 8/24/20
 **/


public class CargoAggregateTest {

    /*
     *  TODO - Write tests for Cargo aggregate
     */
    @Test
    void  create_cargo_booking() throws Exception{

        SimpleDateFormat f = new SimpleDateFormat("yyyy-MMM-dd");
        Cargo cargo = createTestCargoObject();
//        System.out.println("****"+cargo.getRouteSpecification().getArrivalDeadline().toString() + " " + f.parse("2020-September-07"));
        assertThat("GRACE",equalTo(cargo.getId().getBookingId()));
        assertThat(12,equalTo(cargo.getBookingAmount().getBookingAmount()));
        assertThat("NGR",equalTo(cargo.getRouteSpecification().getOrigin().getUnLocCode()));
        assertThat("GHA",equalTo(cargo.getRouteSpecification().getDestination().getUnLocCode()));
        assertThat(cargo.getRouteSpecification().getArrivalDeadline(),equalTo(f.parse("2020-September-07")));
        assertThat(cargo.getDelivery().getLastCargoHandledEvent().getHandlingEventId(),equalTo(null));
    }

    @Test
    void cargoItineraryIsEmptyWhenBooked(){
        Cargo cargo = createTestCargoObject();
        assertThat(cargo.getItinerary().getLegs().isEmpty(),equalTo(true));

    }

    @Test
    void voyageIsNull(){
        Cargo cargo = createTestCargoObject();
        assertThat(cargo.getDelivery().getCurrentVoyage(),equalTo(null));
        }

    @Test
    void deliveryProgressUpdates(){
        Cargo cargo = createTestCargoObject();
        LastCargoHandledEvent event = new LastCargoHandledEvent(
            1,
            "LOAD",
            "1OS2",
            "GSR21"
        );
        cargo.deriveDeliveryProgress(event);
        assertThat(cargo.getDelivery().getCurrentVoyage().getVoyageNumber(),equalTo("1OS2"));
        assertThat(cargo.getDelivery().getLastKnownLocation().getUnLocCode(),equalTo("GSR21"));
        }


    Cargo createTestCargoObject(){
            Cargo cargo = new Cargo(
                    new BookingId("GRACE"),
                    new BookingAmount(12),
                    new RouteSpecification(
                            new Location("NGR"),
                            new Location("GHA"),
                            java.sql.Date.valueOf("2020-09-07")
                    ));

                return cargo;
        }

}
