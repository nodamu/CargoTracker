package com.nodamu.cargotracker.booking.domain.valueobjects;

import com.nodamu.cargotracker.booking.domain.entities.Location;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * A handling activity represents how and where a cargo can be handled, and can
 * be used to express predictions about what is expected to happen to a cargo in
 * the future.
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CargoHandlingActivity {
    private String type;
    private Location location;
    private Voyage voyage;

    public CargoHandlingActivity(String type, Location location) {
        this.type = type;
        this.location = location;
    }


}
