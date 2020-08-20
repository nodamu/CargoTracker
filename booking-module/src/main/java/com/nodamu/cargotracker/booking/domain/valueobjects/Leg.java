package com.nodamu.cargotracker.booking.domain.valueobjects;

import com.nodamu.cargotracker.booking.domain.entities.Location;

import java.util.Date;

/**
 * @author profnick
 * 8/20/20
 **/

public class Leg {
    private Long id;
    private Voyage voyage;
    private Location loadLocation;
    private Location unloadLocation;
    private Date loadtime;
    private Date unloadTime;

    public Leg(Voyage voyage, Location loadLocation, Location unloadLocation, Date loadtime, Date unloadTime) {
        this.voyage = voyage;
        this.loadLocation = loadLocation;
        this.unloadLocation = unloadLocation;
        this.loadtime = loadtime;
        this.unloadTime = unloadTime;
    }

}
