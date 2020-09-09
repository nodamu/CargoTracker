package com.nodamu.routingservice.adapters.out.persistence.jpaentities;

import com.nodamu.routingservice.domain.entities.CarrierMovement;
import com.nodamu.routingservice.domain.valueobjects.Schedule;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.Collections;
import java.util.List;

/**
 * @author profnick
 * 9/9/20
 **/

@NoArgsConstructor
@Embeddable
public class ScheduleJpaEntity {
    public static final Schedule EMPTY = new Schedule();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "voyage_id")
    private List<CarrierMovementJpaEntity> carrierMovements = Collections.emptyList();

    ScheduleJpaEntity(List<CarrierMovementJpaEntity> carrierMovements) {
        this.carrierMovements = carrierMovements;
    }

    public List<CarrierMovementJpaEntity> getCarrierMovements() {
        return Collections.unmodifiableList(carrierMovements);
    }
}
