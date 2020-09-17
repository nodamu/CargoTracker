package com.nodamu.cargotracker.booking.application.services.outboundservices;

import com.nodamu.cargotracker.shareddomain.model.TransitPath;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author profnick
 * 9/17/20
 **/

@FeignClient(name = "routing-service",fallback = CargoRoutingServiceFallBack.class)
public interface CargoRoutingService {

    @GetMapping(path = "/api/v1/cargorouting/route")
    public TransitPath findOptimalRoute(
            @RequestParam("origin") String originUnLocCode,
            @RequestParam("destination") String destinationUnLocCode,
            @RequestParam("deadline") String deadline
    );
}
