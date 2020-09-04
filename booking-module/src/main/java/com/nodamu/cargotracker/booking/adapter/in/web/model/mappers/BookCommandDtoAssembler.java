package com.nodamu.cargotracker.booking.adapter.in.web.model.mappers;

import com.nodamu.cargotracker.booking.adapter.in.web.model.dto.BookCargoResource;
import com.nodamu.cargotracker.booking.domain.commands.BookCargoCommand;

/**
 * @author profnick
 * 9/3/20
 **/
public class BookCommandDtoAssembler {
    /**
     * Convert book cargo DTO to book command
     * @param bookCargoResource
     * @return
     */
    public static BookCargoCommand toCommandFromDto(BookCargoResource bookCargoResource){
        return new BookCargoCommand(
            bookCargoResource.getBookingAmount(),
            bookCargoResource.getOriginLocation(),
            bookCargoResource.getDestLocation(),
            java.sql.Date.valueOf(bookCargoResource.getDestArrivalDeadline())
        );
    }
}
