package com.nodamu.cargotracker.booking.application.ports.out;

import com.nodamu.cargotracker.booking.domain.valueobjects.CargoItinerary;
import com.nodamu.cargotracker.booking.domain.valueobjects.RouteSpecification;

/**
 * @author profnick
 * 9/11/20
 **/
public interface RouteCargoUseCase {
    CargoItinerary fetchRouteForSpecification(RouteSpecification routeSpecification);
}
