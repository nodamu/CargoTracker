package com.nodamu.cargotracker.booking.domain.valueobjects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author profnick
 * 8/21/20
 **/

@AllArgsConstructor
@Getter
@Setter
public class BookingAmount {
    private Integer bookingAmount;
}
