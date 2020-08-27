package com.nodamu.cargotracker.booking.domain.valueobjects;

import com.nodamu.cargotracker.booking.domain.entities.Location;
import com.nodamu.cargotracker.booking.domain.events.LastCargoHandledEvent;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * @author profnick
 * 8/21/20
 **/

/**
 * Domain class which tracks the progress of the Cargo against the Route Specification / Itinerary and Handling Events.
 */
@NoArgsConstructor
public class Delivery {
    public static final Date ETA_UNKNOWN = null;

    @Getter private RoutingStatus routingStatus;
    @Getter private TransportStatus transportStatus;
    @Getter @Setter private Location lastKnownLocation;
    @Getter private Voyage currentVoyage;
    @Setter @Getter private LastCargoHandledEvent lastCargoHandledEvent;

    //Predictions for the Cargo activity.
    // Helps the operator in determining if anything needs to be changed for the future
    public static final CargoHandlingActivity NO_ACTIVITY = new CargoHandlingActivity();

    private CargoHandlingActivity nextExpectedActivity;

    public Delivery(RouteSpecification routeSpecification, CargoItinerary itinerary, LastCargoHandledEvent lastCargoHandledEvent) {
        this.lastCargoHandledEvent = lastCargoHandledEvent;
        this.routingStatus = calculateRoutingStatus(itinerary, routeSpecification);
        this.transportStatus = calculateTransportStatus();
        this.lastKnownLocation = calculateLastKnownLocation();
        this.currentVoyage = calculateCurrentVoyage();
//        this.nextExpectedActivity = nextExpectedActivity;
    }

    /**
     * Creates a new delivery snapshot to reflect changes in routing, i.e. when
     * the route specification or the itinerary has changed but no additional
     * handling of the cargo has been performed.
     */
    public Delivery updateOnRouting(RouteSpecification routeSpecification,
                                    CargoItinerary itinerary) {


        return new Delivery(routeSpecification, itinerary, this.lastCargoHandledEvent);
    }


    /**
     * Static factory method for Delivery object creation
     * @param routeSpecification
     * @param itinerary
     * @param lastCargoHandledEvent
     * @return
     */
    public static Delivery derivedFrom(RouteSpecification routeSpecification,
                                       CargoItinerary itinerary, LastCargoHandledEvent lastCargoHandledEvent) {

        return new Delivery(routeSpecification, itinerary, lastCargoHandledEvent);
    }

    /**
     * Method for calculating routing status of a Cargo
     * @param itinerary
     * @param routeSpecification
     * @return
     */
    private RoutingStatus calculateRoutingStatus(CargoItinerary itinerary, RouteSpecification routeSpecification){
        // If there's nothing in the itinerary then cargo hasn't been routed yet
        if(itinerary == null || itinerary == CargoItinerary.EMPTY_ITINERARY){
            return RoutingStatus.NOT_ROUTED;
        }else {
            return RoutingStatus.ROUTED;
        }

    }

    /**
     * Method for calculating the Transport Status of a Cargo
     * @return
     */
    private TransportStatus calculateTransportStatus(){
        System.out.println("Transport Status for last event"+lastCargoHandledEvent.getHandlingEventType());
        if (lastCargoHandledEvent.getHandlingEventType() == null  ) {
            return TransportStatus.NOT_RECEIVED;
        }

        switch (lastCargoHandledEvent.getHandlingEventType()) {
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
     * Method calculates last known location from last cargo handled event
      * @return
     */
    public Location calculateLastKnownLocation() {
        if(lastCargoHandledEvent != null){
            return new Location(lastCargoHandledEvent.getHandlingEventLocation());
        }else {
            return null;
        }
    }

    /**
     * Method for calculating current voyage
     * @return
     */
    public Voyage calculateCurrentVoyage(){
            if(getTransportStatus().equals(TransportStatus.ONBOARD_CARRIER)
                && lastCargoHandledEvent != null){
                return new Voyage(lastCargoHandledEvent.getHandlingEventVoyage());
            } else {
                return null;
            }
    }


    }
