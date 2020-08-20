package com.nodamu.cargotracker.booking.application.ports.in;

import com.nodamu.cargotracker.booking.domain.commands.BookCommand;

/**
 * @author profnick
 * 8/20/20
 **/
public interface BookCargoUseCase {
    boolean bookCargo(BookCommand command);
}
