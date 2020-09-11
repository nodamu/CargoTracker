package com.nodamu.cargotracker.booking.domain.commands;

import com.nodamu.cargotracker.booking.domain.valueobjects.CargoItinerary;

import java.sql.Date;

/**
 * @author profnick
 * 9/10/20
 **/
public class RouteCargoCommand {
    private String cargoBookingId;
    private String originLocation;
    private String destinationLocation;
    private Date arrivalDeadline;
    private CargoItinerary itinerary;

    public RouteCargoCommand() {
    }

    public RouteCargoCommand(String cargoBookingId) {
        super();
        this.cargoBookingId = cargoBookingId;
    }

    public RouteCargoCommand(String cargoBookingId, String originLocation, String destinationLocation, Date arrivalDeadline) {
        this.cargoBookingId = cargoBookingId;
        this.originLocation = originLocation;
        this.destinationLocation = destinationLocation;
        this.arrivalDeadline = arrivalDeadline;
    }

    public String getCargoBookingId() {
        return cargoBookingId;
    }

    public void setCargoBookingId(String cargoBookingId) {
        this.cargoBookingId = cargoBookingId;
    }

    public String getOriginLocation() {
        return originLocation;
    }

    public void setOriginLocation(String originLocation) {
        this.originLocation = originLocation;
    }

    public String getDestinationLocation() {
        return destinationLocation;
    }

    public void setDestinationLocation(String destinationLocation) {
        this.destinationLocation = destinationLocation;
    }

    public Date getArrivalDeadline() {
        return arrivalDeadline;
    }

    public void setArrivalDeadline(Date arrivalDeadline) {
        this.arrivalDeadline = arrivalDeadline;
    }

    public CargoItinerary getItinerary() {
        return itinerary;
    }

    public void setItinerary(CargoItinerary itinerary) {
        this.itinerary = itinerary;
    }
}
