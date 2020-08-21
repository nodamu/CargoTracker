package com.nodamu.cargotracker.booking.application.services;

import com.nodamu.cargotracker.booking.application.ports.in.BookCargoUseCase;
import org.springframework.stereotype.Service;

/**
 * @author profnick
 * 8/20/20
 **/

@Service
public class BookCargoService implements BookCargoUseCase {
    @Override
    public boolean bookCargo(BookCargoCommand command) {

        return false;
    }

    /**
     * Service Command method to book a new Cargo
     * @return BookingId of the Cargo
     */


}
