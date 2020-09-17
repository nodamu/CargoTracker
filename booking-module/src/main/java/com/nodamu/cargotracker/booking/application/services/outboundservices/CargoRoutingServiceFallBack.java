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
public class CargoRoutingServiceFallBack implements CargoRoutingService {

    private static final Logger logger = LoggerFactory.getLogger(CargoRoutingServiceFallBack.class);

    @Override
    public TransitPath findOptimalRoute(String originUnLocCode, String destinationUnLocCode, String deadline) {
        logger.error("Fallback method for fetchRouteForSpecification is being called");
        return new TransitPath();
    }


}
