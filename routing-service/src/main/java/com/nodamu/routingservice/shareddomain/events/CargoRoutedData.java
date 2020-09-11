package com.nodamu.routingservice.shareddomain.events;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author profnick
 * 9/10/20
 **/

@NoArgsConstructor
@AllArgsConstructor
public class CargoRoutedData {
    private String bookingId;

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }
}
