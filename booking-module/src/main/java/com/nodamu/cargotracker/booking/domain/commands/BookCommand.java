package com.nodamu.cargotracker.booking.domain.commands;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * @author profnick
 * 8/20/20
 **/
@Getter
@Setter
@RequiredArgsConstructor
public class BookCommand {
    private String bookingId;
    @NonNull private int bookingAmount;
    @NonNull private String originLocation;
    @NonNull private String destLocation;
    @NonNull private Date destArrivalDeadline;

}
