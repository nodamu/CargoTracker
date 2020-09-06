package com.nodamu.cargotracker.shareddomain.events;

/**
 * @author profnick
 * 9/4/20
 **/

/**
 * Event class for cargo booking event
 */
public class CargoBookedEvent {
    private CargoBookedEventData eventData;

    public CargoBookedEvent() {
    }

    public CargoBookedEvent(CargoBookedEventData eventData) {
        this.eventData = eventData;
    }

    public CargoBookedEventData getEventData() {
        return eventData;
    }

    public void setEventData(CargoBookedEventData eventData) {
        this.eventData = eventData;
    }
}
