package com.nodamu.cargotracker.booking.adapter.in.web.controller;

import com.nodamu.cargotracker.booking.adapter.in.web.model.dto.BookCargoResource;
import com.nodamu.cargotracker.booking.adapter.in.web.model.mappers.BookCommandDtoAssembler;
import com.nodamu.cargotracker.booking.application.services.commandservices.BookCargoCommandService;
import com.nodamu.cargotracker.booking.domain.aggregates.BookingId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author profnick
 * 9/3/20
 **/

@Controller
@RequestMapping("/cargobooking")
public class BookCargoController {

    @Autowired
    private BookCargoCommandService bookCargoCommandService;


    @PostMapping
    public ResponseEntity<BookingId> bookCargo(@RequestBody BookCargoResource bookCargoResource){
        BookingId bookingId = bookCargoCommandService.bookCargo(
                BookCommandDtoAssembler.toCommandFromDto(bookCargoResource));
        return  ResponseEntity.ok(bookingId);
    }
}
