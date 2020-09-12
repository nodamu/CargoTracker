package com.nodamu.cargotracker.booking.adapter.in.web.model.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author profnick
 * 9/11/20
 **/

@Getter
@Setter
public class RouteCargoResource {
    private String bookingId;

    public RouteCargoResource() {
    }

    public RouteCargoResource(String bookingId) {
        this.bookingId = bookingId;
    }
}
