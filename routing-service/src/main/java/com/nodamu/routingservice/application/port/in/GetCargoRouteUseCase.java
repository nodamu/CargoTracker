package com.nodamu.routingservice.application.port.in;

import com.nodamu.routingservice.domain.aggregates.Voyage;
import com.nodamu.routingservice.shareddomain.model.TransitPath;

import java.util.List;

/**
 * @author profnick
 * 9/9/20
 **/
public interface GetCargoRouteUseCase {
    List<Voyage> getVoyages();
    TransitPath  findOptimalRoute();
}
