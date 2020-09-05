package com.nodamu.cargotracker.booking.adapter.out.persistence.model.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

/**
 * @author profnick
 * 8/25/20
 **/

@Embeddable
public class RouteSpecificationJpa {
    private static final long serialVersionUID = 1L;

    @Embedded
    @AttributeOverride(name = "unLocCode", column = @Column(name = "spec_origin_id"))
    private LocationJpa origin;

    @Embedded
    @AttributeOverride(name = "unLocCode", column = @Column(name = "spec_destination_id"))
    private LocationJpa destination;

    @Temporal(TemporalType.DATE)
    @Column(name = "spec_arrival_deadline")
    @NotNull
    private Date arrivalDeadline;

    public RouteSpecificationJpa() {
    }

    public RouteSpecificationJpa(LocationJpa origin, LocationJpa destination, Date arrivalDeadline) {
        this.origin = origin;
        this.destination = destination;
        this.arrivalDeadline = (Date) arrivalDeadline.clone();
    }


    public LocationJpa getOrigin() {
        return origin;
    }

    public LocationJpa getDestination() {
        return destination;
    }

    public Date getArrivalDeadline() {
        return arrivalDeadline;
    }
}
