package com.nodamu.cargotracker.booking.adapter.out.persistence;

import com.nodamu.cargotracker.booking.adapter.out.persistence.model.entities.*;
import com.nodamu.cargotracker.booking.adapter.out.persistence.model.mappers.CargoMapper;
import com.nodamu.cargotracker.booking.adapter.out.persistence.repository.CargoJpaRepository;
import com.nodamu.cargotracker.booking.application.ports.out.CargoRepository;
import com.nodamu.cargotracker.booking.domain.aggregates.BookingId;
import com.nodamu.cargotracker.booking.domain.aggregates.Cargo;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author profnick
 * 8/26/20
 **/

@RequiredArgsConstructor
public class CargoPersistenceAdaptor implements CargoRepository {

    private final CargoJpaRepository cargoJpaRepository;

    /**
     * Find cargo booking by Booking ID
     * @param id
     * @return
     */
    @Override
    public Cargo findByBookingId(BookingId id) {
        Optional<CargoJpaEntity> cargo = Optional.of(cargoJpaRepository.findByBookingIdJpa(CargoMapper.toJpaEntity(id)));
        return CargoMapper.mapToDomainEntity(cargo.get());
    }

    /**
     * Find all booked cargo Id's
     * @return
     */
    @Override
    public List<BookingId> findAllBookingIds() {
        List<BookingIdJpa> bookingIds = cargoJpaRepository.findAllBookingIdJpa();
        List<BookingId> bookingIdsEntity = new ArrayList<>();
        for(BookingIdJpa bookingId : bookingIds){
            bookingIdsEntity.add(
                    new BookingId(bookingId.getId()));
        }

        return bookingIdsEntity;
    }

    /**
     * Find all booked Cargo's
     * @return
     */
    @Override
    public List<Cargo> findAll() {
        List<CargoJpaEntity> cargosJpa = cargoJpaRepository.findAll();
        List<Cargo> cargos = new ArrayList<>();
        return cargosJpa.stream()
                .map(CargoMapper::mapToDomainEntity)
                .collect(Collectors.toList());

    }

    /**
     * Implementation of cargo booking method as defined in repository interface
     * @param cargo - Cargo domain entity
     */
    @Override
    public void saveBooking(Cargo cargo) {
        cargoJpaRepository.save(CargoMapper.toCargoJpaEntity(cargo));
    }

    @Override
    public void saveRoutedBookingWithItinerary(Cargo cargo) {
       CargoJpaEntity cargoJpaEntity = cargoJpaRepository.findByBookingIdJpa(new BookingIdJpa(cargo.getId().getBookingId()));
       cargoJpaEntity.setDelivery(DeliveryJpa.deriveFrom(cargo.getDelivery().getRoutingStatus(),
               cargo.getDelivery().getTransportStatus(),
               new LocationJpa(cargo.getDelivery().getLastKnownLocation().getUnLocCode()),
               cargo.getDelivery().getLastCargoHandledEvent()));
       cargoJpaEntity.setItinerary(new CargoItineraryJpa((List<LegJpa>) cargo.getItinerary().getLegs()
               .stream()
               .map(leg -> new LegJpa(
                       new VoyageJpa(leg.getVoyageNumber().getVoyageNumber()),
                       new LocationJpa(leg.getLoadLocation().getUnLocCode()),
                       new LocationJpa(leg.getUnLoadLocation().getUnLocCode()),
                       leg.getLoadTimeDate(),
                       leg.getUnLoadTimeDate()))
               .collect(Collectors.toList())));
       cargoJpaRepository.save(cargoJpaEntity);
    }


}
