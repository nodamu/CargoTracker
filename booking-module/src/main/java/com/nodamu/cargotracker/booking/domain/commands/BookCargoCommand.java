package com.nodamu.cargotracker.booking.domain.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author profnick
 * 8/22/20
 **/
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookCargoCommand {
    private String bookingId;
    private BigDecimal bookingAmount;
    private String originLocation;
    private String destLocation;
    private Date destArrivalDeadline;

}
