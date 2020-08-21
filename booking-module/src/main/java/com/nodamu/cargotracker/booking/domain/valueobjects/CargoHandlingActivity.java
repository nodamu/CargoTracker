package com.nodamu.cargotracker.booking.domain.valueobjects;

import com.nodamu.cargotracker.booking.domain.entities.Location;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author profnick
 * 8/21/20
 **/

/**
 * A handling activity represents how and where a cargo can be handled, and can
 * be used to express predictions about what is expected to happen to a cargo in
 * the future.
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CargoHandlingActivity {

    // Next expected handling event type
    private String type;

    // Next expected location Id
    private Location location;

    // Next expected voyage id
    private Voyage voyage;

    public CargoHandlingActivity(String type, Location location) {
        this.type = type;
        this.location = location;
    }
}
