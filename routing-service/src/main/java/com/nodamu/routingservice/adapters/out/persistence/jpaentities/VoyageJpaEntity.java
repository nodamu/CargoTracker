package com.nodamu.routingservice.adapters.out.persistence.jpaentities;

import com.nodamu.routingservice.domain.valueobjects.Schedule;
import com.nodamu.routingservice.domain.valueobjects.VoyageNumber;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author profnick
 * 9/9/20
 **/

@Entity
@Table(name = "Voyage")
@Getter
public class VoyageJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    @NotNull
    private ScheduleJpaEntity schedule;

    @Embedded
    private VoyageNumberJpaEntity voyageNumber;

    public VoyageJpaEntity(ScheduleJpaEntity schedule, VoyageNumberJpaEntity voyageNumber) {
        this.schedule = schedule;
        this.voyageNumber = voyageNumber;
    }

    public VoyageJpaEntity() {
    }
}
