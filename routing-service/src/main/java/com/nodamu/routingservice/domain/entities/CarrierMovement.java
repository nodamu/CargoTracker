package com.nodamu.routingservice.domain.entities;

import com.nodamu.routingservice.domain.valueobjects.Location;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

/**
 * @author profnick
 * 9/9/20
 **/

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CarrierMovement {
    private Date arrivalDate;
    private Date departureDate;
    private Location arrivalLocation;
    private Location departureLocation;
}
