package com.nodamu.routingservice.application.services.queryservices;

import com.nodamu.routingservice.application.port.in.GetCargoRouteUseCase;
import com.nodamu.routingservice.domain.aggregates.Voyage;

import java.util.List;

/**
 * @author profnick
 * 9/9/20
 **/
public class CargoRouteRoutingQueryService implements GetCargoRouteUseCase {

    @Override
    public List<Voyage> getItinerary() {
        /**
         * TODO - Implement with JPA
         */
        return null;
    }
}
