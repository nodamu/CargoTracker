package com.nodamu.cargotracker.booking.adapter.out.persistence.model.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;

/**
 * @author profnick
 * 8/25/20
 **/
@Embeddable
public class BookingAmountJpa {
    @Column(name = "booking_amount", unique = true, updatable = false)
    private Integer bookingAmount;

    public BookingAmountJpa() {
    }

    public BookingAmountJpa(Integer bookingAmount) {
            this.bookingAmount = bookingAmount;
    }

    public Integer getBookingAmount() {
        return bookingAmount;
    }

    public void setBookingAmount(Integer bookingAmount) {
        this.bookingAmount = bookingAmount;
    }
}
