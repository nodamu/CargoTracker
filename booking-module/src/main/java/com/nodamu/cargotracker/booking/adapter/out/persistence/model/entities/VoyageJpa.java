package com.nodamu.cargotracker.booking.adapter.out.persistence.model.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author profnick
 * 8/25/20
 **/

@Embeddable
public class VoyageJpa {

    @Column(name = "voyage_id")
    private String voyageNumber;

    public VoyageJpa(String voyageNumber) {
        this.voyageNumber = voyageNumber;
    }

    public VoyageJpa() {
    }

    public String getVoyageNumber() {
        return voyageNumber;
    }

    public void setVoyageNumber(String voyageNumber) {
        this.voyageNumber = voyageNumber;
    }
}
