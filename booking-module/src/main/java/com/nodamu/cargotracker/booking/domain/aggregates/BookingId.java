package com.nodamu.cargotracker.booking.domain.aggregates;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author profnick
 * 8/21/20
 **/

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BookingId implements Serializable {
    private String bookingId;
}
