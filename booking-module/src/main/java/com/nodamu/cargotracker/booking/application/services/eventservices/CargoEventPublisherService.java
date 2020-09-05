package com.nodamu.cargotracker.booking.application.services.eventservices;

import com.nodamu.cargotracker.booking.adapter.out.messagebrokers.CargoEventSource;
import com.nodamu.cargotracker.shareddomain.events.CargoBookedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * @author profnick
 * 9/4/20
 **/

/**
 * Cargo publisher service class
 * This service class is injected with the rabbitmq publishing implementation
 */
@Service
public class CargoEventPublisherService {

    Logger logger = LoggerFactory.getLogger(getClass());

    CargoEventSource cargoEventSource;

    @Autowired
    public CargoEventPublisherService(CargoEventSource cargoEventSource) {
        this.cargoEventSource = cargoEventSource;
    }

    @TransactionalEventListener
    public void handleCargoBookedEvent(CargoBookedEvent cargoBookedEvent){
        logger.info("Publishing booked cargo event with ID -> {}", cargoBookedEvent.getEventData().getBookingId());
        cargoEventSource.cargoBooking().send(MessageBuilder.withPayload(cargoBookedEvent).build());
    }
}
