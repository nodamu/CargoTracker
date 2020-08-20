package com.nodamu.cargotracker.booking.domain.valueobjects;

import com.nodamu.cargotracker.booking.domain.entities.Location;
import com.nodamu.cargotracker.booking.domain.events.LastCargoHandledEvent;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author profnick
 * 8/20/20
 **/

/**
 * Domain class which tracks the progress of the Cargo against the Route Specification / Itinerary and Handling Events.
 */
public class Delivery {
    public static final Date ETA_UNKNOWN = null;

    @Getter
    @Setter
    private RoutingStatus routingStatus;

    @Getter
    @Setter
    private TransportStatus transportStatus;

    @Getter
    @Setter
    private Location lastKnownLocation;

    @Getter
    private Voyage currentVoyage;

    private LastCargoHandledEvent lastEvent;

    public static final CargoHandlingActivity NO_ACTIVITY = new CargoHandlingActivity();

    private CargoHandlingActivity nextExpectedActivity;

    public Delivery(LastCargoHandledEvent lastEvent, RouteSpecification routeSpecification, CargoItinerary itinerary) {
        this.lastEvent = lastEvent;
        this.routingStatus = calculateRoutingStatus(itinerary,
                routeSpecification);
        this.transportStatus = calculateTransportStatus();
        this.lastKnownLocation = calculateLastKnownLocation();
        this.currentVoyage = calculateCurrentVoyage();
        //this.nextExpectedActivity = calculateNextExpectedActivity(
        // routeSpecification, itinerary);
    }

    /**
     * Creates a new delivery snapshot to reflect changes in routing, i.e. when
     * the route specification or the itinerary has changed but no additional
     * handling of the cargo has been performed.
     */
    public Delivery updateOnRouting(RouteSpecification routeSpecification,
                                    CargoItinerary itinerary) {


        return new Delivery(this.lastEvent, routeSpecification, itinerary);
    }

    /**
     * Method to calculate the Routing status of a Cargo
     *
     * @param itinerary
     * @param routeSpecification
     * @return
     */
    private RoutingStatus calculateRoutingStatus(CargoItinerary itinerary,
                                                 RouteSpecification routeSpecification) {
        if (itinerary == null || itinerary == CargoItinerary.EMPTY_ITINERARY) {
            return RoutingStatus.NOT_ROUTED;
        } else {
            return RoutingStatus.ROUTED;
        }
    }

    /**
     * Method to calculate the Transposrt Status of a Cargo
     * @return
     */
    private TransportStatus calculateTransportStatus() {
        System.out.println("Transport Status for last event"+lastEvent.getHandlingEventType());
        if (lastEvent.getHandlingEventType() == null) {
            return TransportStatus.NOT_RECEIVED;
        }

        switch (lastEvent.getHandlingEventType()) {
            case "LOAD":
                return TransportStatus.ONBOARD_CARRIER;
            case "UNLOAD":
            case "RECEIVE":
            case "CUSTOMS":
                return TransportStatus.IN_PORT;
            case "CLAIM":
                return TransportStatus.CLAIMED;
            default:
                return TransportStatus.UNKNOWN;
        }
    }

    /**
     * Calculate Last known location
     * @return
     */
    private Location calculateLastKnownLocation() {
        if (lastEvent != null) {
            return new Location(lastEvent.getHandlingEventLocation());
        } else {
            return null;
        }
    }

    /**
     *
     * @return
     */
    private Voyage calculateCurrentVoyage() {
        if (getTransportStatus().equals(TransportStatus.ONBOARD_CARRIER) && lastEvent != null) {
            return new Voyage(lastEvent.getHandlingEventVoyage());
        } else {
            return null;
        }
    }


}
