package com.nodamu.cargotracker.booking.adapter.in.web.controller.api.v1;

import com.nodamu.cargotracker.booking.adapter.in.web.model.dto.BookCargoResource;
import com.nodamu.cargotracker.booking.adapter.in.web.model.mappers.BookCommandDtoAssembler;
import com.nodamu.cargotracker.booking.application.services.commandservices.BookCargoCommandService;
import com.nodamu.cargotracker.booking.domain.aggregates.BookingId;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author profnick
 * 9/3/20
 **/

@RestController
@RequestMapping("/api/v1/cargobooking")
@Api(value = "Cargo Booking Controller",  description = " Endpoints for booking cargo and finding cargo ", tags = "Cargo Booking Commands")
public class BookCargoController {

    private final BookCargoCommandService bookCargoCommandService;

    public BookCargoController(BookCargoCommandService bookCargoCommandService) {
        this.bookCargoCommandService = bookCargoCommandService;
    }

    @PostMapping
    public ResponseEntity<BookingId> bookCargo(@RequestBody BookCargoResource bookCargoResource){
        BookingId bookingId = bookCargoCommandService.bookCargo(
                BookCommandDtoAssembler.toCommandFromDto(bookCargoResource));
        return  ResponseEntity.ok(bookingId);
    }
}
