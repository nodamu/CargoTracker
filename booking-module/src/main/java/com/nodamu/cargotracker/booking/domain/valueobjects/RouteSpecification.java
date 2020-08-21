package com.nodamu.cargotracker.booking.domain.valueobjects;

import com.nodamu.cargotracker.booking.domain.entities.Location;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author profnick
 * 8/21/20
 **/

/**
 * Route specification of the Cargo
 */
@Getter
@Setter
public class RouteSpecification {
    private Location origin;
    private Location destination;
    private Date arrivalDeadline;

    /**
     * We create a route specification for each cargo booking from
     * @param origin
     * @param destination
     * @param arrivalDeadline
     */
    public RouteSpecification(Location origin, Location destination, Date arrivalDeadline) {
        this.setOrigin(origin);
        this.setDestination(destination);
        this.setArrivalDeadline((Date) arrivalDeadline.clone());
    }
}
