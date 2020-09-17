package com.nodamu.cargotracker.booking.application.services.outboundservices;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.nodamu.cargotracker.booking.application.ports.out.RouteCargoUseCase;
import com.nodamu.cargotracker.booking.domain.entities.Location;
import com.nodamu.cargotracker.booking.domain.valueobjects.CargoItinerary;
import com.nodamu.cargotracker.booking.domain.valueobjects.Leg;
import com.nodamu.cargotracker.booking.domain.valueobjects.RouteSpecification;
import com.nodamu.cargotracker.booking.domain.valueobjects.Voyage;
import com.nodamu.cargotracker.shareddomain.model.TransitEdge;
import com.nodamu.cargotracker.shareddomain.model.TransitPath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author profnick
 * 9/11/20
 **/

@Service
public class CargoRoutingService implements RouteCargoUseCase {

    private static final Logger logger = LoggerFactory.getLogger(CargoRoutingService.class);

    private final RestTemplate restTemplate;

    public CargoRoutingService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    @HystrixCommand(fallbackMethod = "fetchRouteForSpecificationFallback", commandProperties = {@HystrixProperty(name="execution.timeout.enabled", value="false")})
    public CargoItinerary fetchRouteForSpecification(RouteSpecification routeSpecification) {

        String uri = "http://routing-service";

        final String REST_URI= uri+"/api/v1/cargorouting/route?origin={origin}&destination={destination}&deadline={deadline}";

        TransitPath transitPath =restTemplate.getForObject( REST_URI, TransitPath.class,  routeSpecification.getOrigin().getUnLocCode(),
                routeSpecification.getDestination().getUnLocCode(),
                routeSpecification.getArrivalDeadline().toString());

        assert transitPath != null;
        return toCargoItinerary(transitPath);
    }

    public CargoItinerary fetchRouteForSpecificationFallback(RouteSpecification routeSpecification){
        logger.error("Fallback method for fetchRouteForSpecification is being called");
        return new CargoItinerary();
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
