package com.nodamu.cargotracker.booking.adapter.out.persistence.repository;

import com.nodamu.cargotracker.booking.adapter.out.persistence.model.entities.CargoJpaEntity;
import com.nodamu.cargotracker.booking.domain.aggregates.BookingId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author profnick
 * 8/26/20
 **/
public interface CargoJpaRepository extends JpaRepository<CargoJpaEntity, Long> {
    CargoJpaEntity findByBookingId(String bookingId);
    List<BookingId> findAllBookingIds();
    List<CargoJpaEntity> findAll();
}

