package com.nodamu.cargotracker.booking.adapter.out.persistence;

import com.nodamu.cargotracker.booking.adapter.out.persistence.model.entities.BookingIdJpa;
import com.nodamu.cargotracker.booking.adapter.out.persistence.model.entities.CargoJpaEntity;
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

    @Override
    public Cargo findByBookingId(BookingId id) {
        Optional<CargoJpaEntity> cargo = Optional.of(cargoJpaRepository.findByBookingIdJpa(CargoMapper.toJpaEntity(id)));
        if(!cargo.isPresent()){
//            TODO - Write custom exception class for not found
            throw  new EntityNotFoundException();
        }else{
            return CargoMapper.mapToDomainEntity(cargo.get());
        }
    }


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

    @Override
    public List<Cargo> findAll() {
        List<CargoJpaEntity> cargosJpa = cargoJpaRepository.findAll();
        List<Cargo> cargos = new ArrayList<>();
        return cargosJpa.stream()
                .map(CargoMapper::mapToDomainEntity)
                .collect(Collectors.toList());

    }
}
