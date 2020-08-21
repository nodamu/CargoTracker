package com.nodamu.cargotracker.booking.application.services;

import com.nodamu.cargotracker.booking.application.ports.in.RouteCargoUseCase;
import org.springframework.stereotype.Service;

/**
 * @author profnick
 * 8/21/20
 **/
@Service
public class RouteCargoService  implements RouteCargoUseCase {
    @Override
    public boolean routeCargo(RouteCargoCommand command) {
    /*
        Todo - Add route handler logic from example Cargo aggregate
     */
        return false;
    }
}
