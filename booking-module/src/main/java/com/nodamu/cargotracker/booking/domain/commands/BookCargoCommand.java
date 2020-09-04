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

@NoArgsConstructor
@Getter
@Setter
public class BookCargoCommand {
    private String bookingId;
    private Integer bookingAmount;
    private String originLocation;
    private String destLocation;
    private Date destArrivalDeadline;

    public BookCargoCommand(Integer bookingAmount, String originLocation, String destLocation, Date destArrivalDeadline) {
        this.bookingAmount = bookingAmount;
        this.originLocation = originLocation;
        this.destLocation = destLocation;
        this.destArrivalDeadline = destArrivalDeadline;
    }

}
