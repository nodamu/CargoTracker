package com.nodamu.cargotracker.booking.application.ports.out;

import com.nodamu.cargotracker.booking.domain.aggregates.BookingId;
import com.nodamu.cargotracker.booking.domain.aggregates.Cargo;

import java.util.List;

/**
 * @author profnick
 * 8/22/20
 **/
public interface CargoRepository {
    Cargo findByBookingId(BookingId id);
    void  saveCargoBooking(Cargo cargo);
    List<BookingId> findAllBookingIds();
    List<Cargo> findAll();
}
