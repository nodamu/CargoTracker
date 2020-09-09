package com.nodamu.routingservice.adapters.out.persistence.model.mappers;

import com.nodamu.routingservice.adapters.out.persistence.model.entities.CarrierMovementJpaEntity;
import com.nodamu.routingservice.adapters.out.persistence.model.entities.VoyageJpaEntity;
import com.nodamu.routingservice.domain.aggregates.Voyage;
import com.nodamu.routingservice.domain.entities.CarrierMovement;
import com.nodamu.routingservice.domain.valueobjects.Location;
import com.nodamu.routingservice.domain.valueobjects.Schedule;
import com.nodamu.routingservice.domain.valueobjects.VoyageNumber;

import java.util.ArrayList;
import java.util.List;

/**
 * @author profnick
 * 9/9/20
 **/

/**
 * Mapper class for mapping JPA entities to domain entities
 */
public class VoyageMapper {

    public static Voyage toVoyageDomainEntity(VoyageJpaEntity voyageJpaEntity){
            Voyage voyage = new Voyage();
            voyage.setVoyageNumber(new VoyageNumber(voyageJpaEntity.getVoyageNumber().getVoyageNumber()));
            voyage.setSchedule(new Schedule(toCarrierMovementDomainEntity(voyageJpaEntity.getSchedule().getCarrierMovements())));
            return voyage;
    }

   public static List<CarrierMovement> toCarrierMovementDomainEntity(List<CarrierMovementJpaEntity> carrierMovementJpaEntity){
            List<CarrierMovement> carrierMovements = new ArrayList<>();
            carrierMovementJpaEntity
                    .forEach((cmj) -> carrierMovements.add(new CarrierMovement(
                            cmj.getArrivalDate(),
                            cmj.getDepartureDate(),
                            new Location(cmj.getArrivalLocation().getUnLocCode()),
                            new Location(cmj.getDepartureLocation().getUnLocCode())
                    )));
            return carrierMovements;
        }
}

