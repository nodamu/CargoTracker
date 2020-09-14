package com.nodamu.cargotracker.shareddomain.events;

/**
 * @author profnick
 * 9/14/20
 **/
public class CargoRoutedEvent {

    private CargoRoutedEventData cargoRoutedEventData;

    public CargoRoutedEvent(CargoRoutedEventData cargoRoutedEventData) {
        this.cargoRoutedEventData = cargoRoutedEventData;
    }

    public CargoRoutedEventData getCargoRoutedEventData() {
        return cargoRoutedEventData;
    }
}
