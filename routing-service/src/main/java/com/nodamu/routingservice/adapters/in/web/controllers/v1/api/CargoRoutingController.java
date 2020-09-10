package com.nodamu.routingservice.adapters.in.web.controllers.v1.api;

import com.nodamu.routingservice.application.services.queryservices.CargoRouteRoutingQueryService;
import com.nodamu.routingservice.shareddomain.model.TransitPath;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author profnick
 * 9/10/20
 **/

@RestController
@RequestMapping("/api/v1/cargorouting")
public class CargoRoutingController {

    private final CargoRouteRoutingQueryService service;

    public CargoRoutingController(CargoRouteRoutingQueryService service) {
        this.service = service;
    }

    @GetMapping("/route")
    public ResponseEntity<TransitPath> findOptimalRoute(
            @RequestParam("origin") String origin,
            @RequestParam("destination") String destination,
            @RequestParam("deadline") String deadline
    ){
            TransitPath transitPath = service.findOptimalRoute();
            return ResponseEntity.ok(transitPath);
        }
}
