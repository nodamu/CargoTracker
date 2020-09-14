package com.nodamu.cargotracker.shareddomain.events;

/**
 * @author profnick
 * 9/14/20
 **/
public class CargoRoutedEventData {
    private String bookingId;

    public CargoRoutedEventData(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getBookingId() {
        return bookingId;
    }
}
