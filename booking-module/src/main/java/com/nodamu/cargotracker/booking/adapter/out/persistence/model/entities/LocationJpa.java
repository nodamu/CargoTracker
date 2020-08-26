package com.nodamu.cargotracker.booking.adapter.out.persistence.model.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author profnick
 * 8/25/20
 **/

@Embeddable
public class LocationJpa {
    @Column(name = "origin_id", insertable = false, updatable = false)
    private String unLocCode;

    public LocationJpa() {
    }

    public LocationJpa(String unLocCode) {
        this.unLocCode = unLocCode;
    }

    public String getUnLocCode() {
        return unLocCode;
    }

    public void setUnLocCode(String unLocCode) {
        this.unLocCode = unLocCode;
    }
}
