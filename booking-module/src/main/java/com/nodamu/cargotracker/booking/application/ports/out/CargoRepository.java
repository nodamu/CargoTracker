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
    List<BookingId> findAllBookingIds();
    List<Cargo> findAll();
    void saveBooking(Cargo cargo);
    void saveRoutedBooking(Cargo cargo);
}
