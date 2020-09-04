package com.nodamu.cargotracker.booking.adapter.in.web.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/**
 * @author profnick
 * 9/3/20
 **/

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookCargoResource {
    private int bookingAmount;
    private String originLocation;
    private String destLocation;
    private LocalDate destArrivalDeadline;
}
