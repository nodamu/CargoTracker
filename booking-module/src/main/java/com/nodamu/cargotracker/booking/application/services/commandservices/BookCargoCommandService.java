package com.nodamu.cargotracker.booking.application.services.commandservices;

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
import org.springframework.transaction.annotation.Transactional;

import java.lang.invoke.MethodHandles;
import java.util.UUID;

/**
 * @author profnick
 * 8/20/20
 **/

@Service
public class BookCargoCommandService implements BookCargoUseCase {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private CargoRepository cargoRepository;

    /**
     *
     * @param cargoRepository
     */

    public BookCargoCommandService(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    @Override
    @Transactional
    public BookingId bookCargo(BookCargoCommand command) {
        String random = UUID.randomUUID().toString().toUpperCase();
        String normalized = random.substring(0, random.indexOf("-"));
        logger.info("Booking Id creating -> {} ",normalized);
        command.setBookingId(normalized);
//        command.setBookingId(random);
        Cargo cargo = new Cargo(
                new BookingId(command.getBookingId()),
                new BookingAmount(command.getBookingAmount()),
                new RouteSpecification(
                        new Location(command.getOriginLocation()),
                        new Location(command.getDestLocation()),
                        command.getDestArrivalDeadline()
                )

        );

        // Save booking to database
        cargoRepository.saveBooking(cargo);

        return new BookingId(normalized);
    }



}
