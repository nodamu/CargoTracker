package com.nodamu.cargotracker.booking.adapter.out.persistence.model.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author profnick
 * 8/25/20
 **/
@Embeddable
public class BookingIdJpa implements Serializable {

    @Column(name = "booking_id",length = 500)
    private String id;

    public BookingIdJpa(String id) {
        this.id = id;
    }

    public BookingIdJpa() {
    }

    public String getId() {
        return id;
    }


}
