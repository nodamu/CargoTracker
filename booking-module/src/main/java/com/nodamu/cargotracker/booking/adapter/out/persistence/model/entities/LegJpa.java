package com.nodamu.cargotracker.booking.adapter.out.persistence.model.entities;

/**
 * @author profnick
 * 8/25/20
 **/

import com.nodamu.cargotracker.booking.domain.entities.Location;
import com.nodamu.cargotracker.booking.domain.valueobjects.Voyage;
import com.sun.istack.NotNull;

import javax.persistence.GeneratedValue;
import javax.persistence.*;
import javax.xml.crypto.Data;
import java.util.Date;

@Entity
@Table(name = "Leg")
public class LegJpa {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private VoyageJpa voyage;

    @Embedded
    @AttributeOverride(name = "unLocCode", column = @Column(name = "load_location_id"))
    private LocationJpa loadLocation;

    @Embedded
    @AttributeOverride(name = "unLocCode", column = @Column(name = "unload_location_id"))
    private LocationJpa unloadLocation;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "load_time")
    @NotNull
    private Date loadTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "unload_time")
    @NotNull
    private Date unloadTime;


    protected LegJpa() {
    }

    public LegJpa(VoyageJpa voyage, LocationJpa loadLocation,LocationJpa unloadLocation, Date loadTime, Date unloadTime){
        this.voyage = voyage;
        this.loadLocation = loadLocation;
        this.unloadLocation = unloadLocation;
        this.loadTime = loadTime;
        this.unloadTime = unloadTime;
    }


}

