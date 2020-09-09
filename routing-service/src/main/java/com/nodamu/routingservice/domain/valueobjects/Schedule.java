package com.nodamu.routingservice.domain.valueobjects;

import com.nodamu.routingservice.domain.entities.CarrierMovement;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

/**
 * @author profnick
 * 9/8/20
 **/

@NoArgsConstructor
public class Schedule {
    public static final Schedule EMPTY = new Schedule();

    private List<CarrierMovement> carrierMovements = Collections.emptyList();

    public Schedule(List<CarrierMovement> carrierMovements) {
        this.carrierMovements = carrierMovements;
    }

    public List<CarrierMovement> getCarrierMovements() {
        return Collections.unmodifiableList(carrierMovements);
    }
}
