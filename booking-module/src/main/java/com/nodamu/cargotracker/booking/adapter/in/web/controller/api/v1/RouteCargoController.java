package com.nodamu.cargotracker.booking.adapter.in.web.controller.api.v1;

import com.nodamu.cargotracker.booking.adapter.in.web.model.dto.RouteCargoResource;
import com.nodamu.cargotracker.booking.application.services.commandservices.RouteCargoCommandService;
import com.nodamu.cargotracker.booking.domain.commands.RouteCargoCommand;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author profnick
 * 9/11/20
 **/

@RestController
@RequestMapping("/api/v1/cargobooking/routecargo")
@Api(value = "Cargo Router Controller",  description = " Endpoints for Routing cargo  ", tags = "Cargo Routing Commands")
public class RouteCargoController {

    private final RouteCargoCommandService cargoCommandService;

    public RouteCargoController(RouteCargoCommandService cargoCommandService) {
        this.cargoCommandService = cargoCommandService;
    }

    @PostMapping
    public ResponseEntity<String> routeCargo(@RequestBody RouteCargoResource resource){
        RouteCargoCommand command = new RouteCargoCommand(resource.getBookingId());
        cargoCommandService.routeCargo(command);
        return ResponseEntity.ok("SUCCESS");
    }
}
