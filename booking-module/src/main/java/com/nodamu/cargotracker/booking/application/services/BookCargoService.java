package com.nodamu.cargotracker.booking.application.services;

import com.nodamu.cargotracker.booking.application.ports.in.BookCargoUseCase;
import com.nodamu.cargotracker.booking.domain.commands.BookCommand;

/**
 * @author profnick
 * 8/20/20
 **/
public class BookCargoService implements BookCargoUseCase {
    @Override
    public boolean bookCargo(BookCommand command) {

        return false;
    }
}
