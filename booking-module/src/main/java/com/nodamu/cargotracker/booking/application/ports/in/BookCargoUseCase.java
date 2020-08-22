package com.nodamu.cargotracker.booking.application.ports.in;

import com.nodamu.cargotracker.booking.domain.aggregates.BookingId;
import com.nodamu.cargotracker.booking.domain.commands.BookCargoCommand;

/**
 * @author profnick
 * 8/22/20
 **/
public interface BookCargoUseCase {

    BookingId bookCargo(BookCargoCommand command);
}
