package com.nodamu.routingservice.application.services.queryservices;

import com.nodamu.routingservice.application.port.in.GetCargoRouteUseCase;
import com.nodamu.routingservice.application.port.out.VoyageRepository;
import com.nodamu.routingservice.domain.aggregates.Voyage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author profnick
 * 9/9/20
 **/

@Service
public class CargoRouteRoutingQueryService implements GetCargoRouteUseCase {

    private final VoyageRepository voyageRepository;

    public CargoRouteRoutingQueryService(VoyageRepository voyageRepository) {
        this.voyageRepository = voyageRepository;
    }

    @Override
    @Transactional
    public List<Voyage> getItinerary() {
        return voyageRepository.findAllVoyages();
    }
}
