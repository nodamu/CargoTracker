package com.nodamu.cargotracker.booking.domain.valueobjects;


import com.nodamu.cargotracker.booking.domain.entities.Location;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class RouteSpecification {
    private Location origin;
    private Location destination;
    private Date arrivalDeadline;

    public RouteSpecification(Location origin, Location destination, Date arrivalDeadline) {
        this.origin = origin;
        this.destination = destination;
        this.arrivalDeadline = arrivalDeadline;
    }
}
