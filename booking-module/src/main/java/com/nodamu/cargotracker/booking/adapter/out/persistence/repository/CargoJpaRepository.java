package com.nodamu.cargotracker.booking.adapter.out.persistence.repository;

import com.nodamu.cargotracker.booking.adapter.out.persistence.model.entities.BookingIdJpa;
import com.nodamu.cargotracker.booking.adapter.out.persistence.model.entities.CargoJpaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author profnick
 * 8/26/20
 **/
public interface CargoJpaRepository extends CrudRepository<CargoJpaEntity, Long> {

    @Query("select c from CargoJpaEntity c " +
            " where c.bookingId =:bookingId")
    CargoJpaEntity findByBookingIdJpa(@Param("bookingId") BookingIdJpa bookingId);

    @Query("select c.bookingId from CargoJpaEntity c")
    List<BookingIdJpa> findAllBookingIdJpa();

    @Query("select c from CargoJpaEntity c ")
    List<CargoJpaEntity> findAll();

}

