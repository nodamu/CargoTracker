package com.nodamu.routingservice.application.services.queryservices;

import com.nodamu.routingservice.application.port.in.GetCargoRouteUseCase;
import com.nodamu.routingservice.application.port.out.VoyageRepository;
import com.nodamu.routingservice.domain.aggregates.Voyage;
import com.nodamu.routingservice.domain.entities.CarrierMovement;
import com.nodamu.routingservice.shareddomain.model.TransitEdge;
import com.nodamu.routingservice.shareddomain.model.TransitPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    public List<Voyage> getVoyages() {
        return voyageRepository.findAllVoyages();
    }

    @Override
    public TransitPath findOptimalRoute() {
        List<Voyage> voyages = getVoyages();
        TransitPath transitPath = new TransitPath();
        List<TransitEdge> transitEdges = new ArrayList<>();
        for(Voyage voyage : voyages){
            TransitEdge transitEdge = new TransitEdge();
            transitEdge.setVoyageNumber(voyage.getVoyageNumber().getVoyageNumber());
            CarrierMovement carrierMovement = voyage.getSchedule().getCarrierMovements().get(0);
            transitEdge.setFromDate(carrierMovement.getArrivalDate());
            transitEdge.setToDate(carrierMovement.getDepartureDate());
            transitEdge.setFromUnLocCode(carrierMovement.getArrivalLocation().getUnLocCode());
            transitEdge.setToUnLocCode(carrierMovement.getDepartureLocation().getUnLocCode());
            transitEdges.add(transitEdge);
        }
        transitPath.setTransitEdges(transitEdges);
        return transitPath;
    }
}
