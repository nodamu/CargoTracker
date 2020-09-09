package com.nodamu.routingservice.adapters.out.persistence;

import com.nodamu.routingservice.adapters.out.persistence.repository.VoyageJpaRepository;
import com.nodamu.routingservice.adapters.out.persistence.model.mappers.VoyageMapper;
import com.nodamu.routingservice.application.port.out.VoyageRepository;
import com.nodamu.routingservice.domain.aggregates.Voyage;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author profnick
 * 9/9/20
 **/
public class VoyagePersistenceAdaptor  implements VoyageRepository {

    private final VoyageJpaRepository voyageJpaRepository;

    @Autowired
    public VoyagePersistenceAdaptor(VoyageJpaRepository voyageJpaRepository) {
        this.voyageJpaRepository = voyageJpaRepository;
    }

    @Override
    public List<Voyage> findAllVoyages() {
        return voyageJpaRepository.findAllVoyages()
                .stream()
                .map(VoyageMapper::toVoyageDomainEntity)
                .collect(Collectors.toList());
    }
}
