package com.nodamu.routingservice.shareddomain.events;

/**
 * @author profnick
 * 9/8/20
 **/

public class CargoBookedEvent {
    CargoBookedEventData cargoBookedEventData;
    public CargoBookedEvent(){}


    public CargoBookedEvent(CargoBookedEventData cargoBookedEventData){
        this.cargoBookedEventData = cargoBookedEventData;
    }

    public void setCargoBookedEventData(CargoBookedEventData cargoBookedEventData){this.cargoBookedEventData = cargoBookedEventData;}
    public CargoBookedEventData getCargoBookedEventData(){
        return cargoBookedEventData;
    }
}
