package com.nodamu.routingservice.shareddomain.events;

/**
 * @author profnick
 * 9/8/20
 **/
public class CargoBookedEventData {
    private String bookingId;

    public CargoBookedEventData(){}
    public CargoBookedEventData(String bookingId){
        this.bookingId = bookingId;

    }

    public void setBookingId(String bookingId){this.bookingId = bookingId;}
    public String getBookingId(){return this.bookingId;}
}
