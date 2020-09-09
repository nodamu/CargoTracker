package com.nodamu.routingservice.application.port.out;

import com.nodamu.routingservice.domain.aggregates.Voyage;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author profnick
 * 9/9/20
 **/

public interface VoyageRepository {
    /**
     * Find all voyage aggregates
     * @return
     */
    List<Voyage> findAllVoyages();
}
