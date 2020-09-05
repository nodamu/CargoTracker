package com.nodamu.cargotracker.shareddomain.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author profnick
 * 9/4/20
 **/

@Getter
@Setter
@NoArgsConstructor
public class CargoBookedEventData {
    private String bookingId;

    public CargoBookedEventData(String bookingId) {
        this.bookingId = bookingId;
    }
}
