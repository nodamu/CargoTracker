package com.nodamu.cargotracker.booking.adapter.out.persistence;

import com.nodamu.cargotracker.booking.adapter.out.persistence.repository.CargoJpaRepository;
import com.nodamu.cargotracker.booking.application.ports.out.CargoRepository;
import com.nodamu.cargotracker.booking.domain.aggregates.BookingId;
import com.nodamu.cargotracker.booking.domain.aggregates.Cargo;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

/**
 * @author profnick
 * 8/26/20
 **/

@RequiredArgsConstructor
public class CargoPersistenceAdaptor implements CargoRepository {

    private final CargoJpaRepository cargoJpaRepository;

    @Override
    public Cargo findByBookingId(BookingId id) {
        return null;
    }

    @Override
    public void saveCargoBooking(Cargo cargo) {

    }

    @Override
    public List<BookingId> findAllBookingIds() {
        return null;
    }

    @Override
    public List<Cargo> findAll() {
        return null;
    }
}
