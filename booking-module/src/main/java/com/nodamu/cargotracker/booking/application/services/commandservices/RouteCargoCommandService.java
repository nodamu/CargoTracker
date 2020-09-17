package com.nodamu.cargotracker.booking.application.services.commandservices;

import com.nodamu.cargotracker.booking.adapter.out.persistence.model.entities.BookingIdJpa;
import com.nodamu.cargotracker.booking.adapter.out.persistence.model.entities.CargoJpaEntity;
import com.nodamu.cargotracker.booking.adapter.out.persistence.model.entities.LocationJpa;
import com.nodamu.cargotracker.booking.adapter.out.persistence.repository.CargoJpaRepository;
import com.nodamu.cargotracker.booking.application.ports.out.CargoRepository;
import com.nodamu.cargotracker.booking.application.ports.out.RouteCargoUseCase;
import com.nodamu.cargotracker.booking.application.services.outboundservices.CargoRoutingService;
import com.nodamu.cargotracker.booking.domain.aggregates.BookingId;
import com.nodamu.cargotracker.booking.domain.aggregates.Cargo;
import com.nodamu.cargotracker.booking.domain.commands.RouteCargoCommand;
import com.nodamu.cargotracker.booking.domain.entities.Location;
import com.nodamu.cargotracker.booking.domain.valueobjects.CargoItinerary;
import com.nodamu.cargotracker.booking.domain.valueobjects.Leg;
import com.nodamu.cargotracker.booking.domain.valueobjects.RouteSpecification;
import com.nodamu.cargotracker.booking.domain.valueobjects.Voyage;
import com.nodamu.cargotracker.shareddomain.model.TransitEdge;
import com.nodamu.cargotracker.shareddomain.model.TransitPath;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author profnick
 * 9/11/20
 **/
@Service
public class RouteCargoCommandService  implements RouteCargoUseCase {
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
            CargoItinerary cargoItinerary = fetchRouteForSpecification(cargo.get().getRouteSpecification());
           if(cargoItinerary.getLegs().size() != 0){
            routeCargoCommand.setItinerary(cargoItinerary);
            cargo.get().assignToRoute(cargoItinerary);
            cargoRepository.saveRoutedBookingWithItinerary(cargo.get());
           }else {
               throw new RuntimeException("Routing failed as routing service is not available");
           }
        } else {
            throw new EntityNotFoundException();
        }
    }


    @Override
    public CargoItinerary fetchRouteForSpecification(RouteSpecification routeSpecification) {
        TransitPath transitPath = cargoRoutingService.findOptimalRoute(
               routeSpecification.getOrigin().getUnLocCode()
               ,routeSpecification.getDestination().getUnLocCode(),
               routeSpecification.getArrivalDeadline().toString());
        if(transitPath.getTransitEdges().size() != 0){
            return toCargoItinerary(transitPath);

        }else {
            return new CargoItinerary();
        }
    }

    /**
     * Anti-corruption layer conversion method from the routing service's domain model (TransitPath and TransitEdges)
     * to the domain model recognized by the Booking Bounded Context (CargoItinerary and Legs)
     * @param transitPath
     * @return
     */
    private CargoItinerary toCargoItinerary(TransitPath transitPath) {

        List<Leg> legs = new ArrayList<>(transitPath.getTransitEdges().size());
        for (TransitEdge edge : transitPath.getTransitEdges()) {
            legs.add(toLeg(edge));
        }

        return new CargoItinerary(legs);

    }

    private Leg toLeg(TransitEdge edge) {
        return new Leg(
                new Voyage(edge.getVoyageNumber()),
                new Location(edge.getFromUnLocCode()),
                new Location(edge.getToUnLocCode()),
                edge.getFromDate(),
                edge.getToDate());
    }
}
