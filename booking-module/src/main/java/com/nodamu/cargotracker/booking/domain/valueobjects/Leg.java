package com.nodamu.cargotracker.booking.domain.valueobjects;

import com.nodamu.cargotracker.booking.domain.entities.Location;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author profnick
 * 8/21/20
 **/
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Leg {
    private Voyage voyageNumber;
    private Location loadLocation;
    private Location unLoadLocation;
    private Date LoadTimeDate;
    private Date unLoadTimeDate;
}
