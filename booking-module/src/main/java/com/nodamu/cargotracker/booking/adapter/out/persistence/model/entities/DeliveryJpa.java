package com.nodamu.cargotracker.booking.adapter.out.persistence.model.entities;

import com.nodamu.cargotracker.booking.domain.events.LastCargoHandledEvent;
import com.nodamu.cargotracker.booking.domain.valueobjects.RoutingStatus;
import com.nodamu.cargotracker.booking.domain.valueobjects.TransportStatus;

import javax.persistence.*;

/**
 * @author profnick
 * 8/25/20
 **/

@Embeddable
public class DeliveryJpa {
    /**
     * TODO
     */

//    public static final Date ETA_UNKOWN = null;

    //Enumerated Types - Routing Status / Transport Status of the Cargo
    @Enumerated(EnumType.STRING)
    @Column(name = "routing_status")
    private RoutingStatus routingStatus; //Routing Status of the Cargo

    @Enumerated(EnumType.STRING)
    @Column(name = "transport_status")
    private TransportStatus transportStatus; //Transport Status of the Cargo

    //Current/PRevious information of the Cargo. Helps the operator in determining the current state is OK.
    @Column(name = "last_known_location_id")
    private LocationJpa lastKnownLocation;

    @Column(name = "current_voyage_id")
    private VoyageJpa currentVoyage;

    @Embedded
    private LastCargoHandledEvent lastEvent;

    //Predictions for the Cargo activity. Helps the operator in determining if anything needs to be changed for the future
    public static final CargoHandlingActivityJpa NO_ACTIVITY = new CargoHandlingActivityJpa();

    @Embedded
    private CargoHandlingActivityJpa nextExpectedActivity;

    public DeliveryJpa(RoutingStatus routingStatus, TransportStatus transportStatus, LocationJpa lastKnownLocation, VoyageJpa currentVoyage, LastCargoHandledEvent lastEvent) {
        this.routingStatus = routingStatus;
        this.transportStatus = transportStatus;
        this.lastKnownLocation = lastKnownLocation;
        this.currentVoyage = currentVoyage;
        this.lastEvent = lastEvent;
//        this.nextExpectedActivity = nextExpectedActivity;
    }

    public DeliveryJpa() {
    }

    public RoutingStatus getRoutingStatus() {
        return routingStatus;
    }

    public void setRoutingStatus(RoutingStatus routingStatus) {
        this.routingStatus = routingStatus;
    }

    public TransportStatus getTransportStatus() {
        return transportStatus;
    }

    public void setTransportStatus(TransportStatus transportStatus) {
        this.transportStatus = transportStatus;
    }

    public LocationJpa getLastKnownLocation() {
        return lastKnownLocation;
    }

    public void setLastKnownLocation(LocationJpa lastKnownLocation) {
        this.lastKnownLocation = lastKnownLocation;
    }

    public VoyageJpa getCurrentVoyage() {
        return currentVoyage;
    }

    public void setCurrentVoyage(VoyageJpa currentVoyage) {
        this.currentVoyage = currentVoyage;
    }

    public LastCargoHandledEvent getLastEvent() {
        return lastEvent;
    }

    public void setLastEvent(LastCargoHandledEvent lastEvent) {
        this.lastEvent = lastEvent;
    }




}
