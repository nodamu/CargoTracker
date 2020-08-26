package com.nodamu.cargotracker.booking.application.services;

import com.nodamu.cargotracker.booking.application.ports.in.BookCargoUseCase;
import com.nodamu.cargotracker.booking.application.ports.out.CargoRepository;
import com.nodamu.cargotracker.booking.domain.aggregates.BookingId;
import com.nodamu.cargotracker.booking.domain.aggregates.Cargo;
import com.nodamu.cargotracker.booking.domain.commands.BookCargoCommand;
import com.nodamu.cargotracker.booking.domain.entities.Location;
import com.nodamu.cargotracker.booking.domain.valueobjects.BookingAmount;
import com.nodamu.cargotracker.booking.domain.valueobjects.CargoItinerary;
import com.nodamu.cargotracker.booking.domain.valueobjects.RouteSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.invoke.MethodHandles;
import java.util.UUID;

/**
 * @author profnick
 * 8/20/20
 **/

@Service
public class BookCargoService implements BookCargoUseCase {

    private Logger logger = LoggerFactory.getLogger(getClass());

//    private CargoRepository cargoRepository;

    /**
     * TODO - Create JPA Implementaton of Cargo repository
     * @param cargoRepository
     */
//    public BookCargoService(CargoRepository cargoRepository) {
//        this.cargoRepository = cargoRepository;
//    }

    @Override
    public BookingId bookCargo(BookCargoCommand command) {
        String random = UUID.randomUUID().toString().toUpperCase();
        logger.info("Booking Id -> {} creating",random);
        command.setBookingId(random.substring(0, random.indexOf("-")));
        Cargo cargo = new Cargo(
                new BookingId(command.getBookingId()),
                new BookingAmount(command.getBookingAmount()),
                new Location(command.getOriginLocation()),
                new RouteSpecification(
                        new Location(command.getOriginLocation()),
                        new Location(command.getDestLocation()),
                        command.getDestArrivalDeadline()
                )
        );
        /**
         * TODO - Add repository methods for saving cargo booking to database
         */
        return new BookingId(random);
    }



}
