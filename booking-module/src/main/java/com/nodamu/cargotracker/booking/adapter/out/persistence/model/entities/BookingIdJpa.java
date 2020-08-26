package com.nodamu.cargotracker.booking.adapter.out.persistence.model.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author profnick
 * 8/25/20
 **/
@Embeddable
public class BookingIdJpa {

    @Column(name = "booking_id")
    private String id;

    public BookingIdJpa(String id) {
        this.id = id;
    }

    protected BookingIdJpa() {
    }

    public String getId() {
        return id;
    }


}
