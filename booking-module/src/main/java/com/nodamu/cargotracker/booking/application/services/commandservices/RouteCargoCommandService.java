package com.nodamu.cargotracker.booking.application.services.commandservices;

import com.nodamu.cargotracker.booking.application.ports.out.CargoRepository;
import com.nodamu.cargotracker.booking.application.services.outboundservices.CargoRoutingService;
import com.nodamu.cargotracker.booking.domain.aggregates.BookingId;
import com.nodamu.cargotracker.booking.domain.aggregates.Cargo;
import com.nodamu.cargotracker.booking.domain.commands.RouteCargoCommand;
import com.nodamu.cargotracker.booking.domain.valueobjects.CargoItinerary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

/**
 * @author profnick
 * 9/11/20
 **/
@Service
public class RouteCargoCommandService {
    private final CargoRoutingService cargoRoutingService;
    private final CargoRepository cargoRepository;

    public RouteCargoCommandService(CargoRoutingService cargoRoutingService, CargoRepository cargoRepository) {
        this.cargoRoutingService = cargoRoutingService;
        this.cargoRepository = cargoRepository;
    }

    /**
     * Assign a route to booked cargo
     * @param routeCargoCommand
     */
    @Transactional
    public void routeCargo(RouteCargoCommand routeCargoCommand){
       Optional<Cargo> cargo = Optional.ofNullable(cargoRepository.findByBookingId(new BookingId(routeCargoCommand.getCargoBookingId())));
        if(cargo.isPresent()){
            CargoItinerary cargoItinerary = cargoRoutingService.fetchRouteForSpecification(cargo.get().getRouteSpecification());
            routeCargoCommand.setItinerary(cargoItinerary);
            cargo.get().assignToRoute(cargoItinerary);
            cargoRepository.saveBooking(cargo.get());
        } else {
            throw new EntityNotFoundException();
        }
    }
}
