package com.nodamu.cargotracker.booking.adapter.out.messagebrokers;

import com.nodamu.cargotracker.booking.domain.aggregates.Cargo;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author profnick
 * 9/4/20
 **/

/**
 * Interface for spring cloud stream channel
 * Implementation is injected into service
 */
public interface CargoEventSource {
//    String OUTPUT = "cargoBookingChannel";


    @Output("cargoBookingChannel")
    MessageChannel cargoBooking();

    @Output("cargoRoutingChannel")
    MessageChannel cargoRouting();
}
