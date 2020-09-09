package com.nodamu.routingservice.adapters.out.persistence.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author profnick
 * 9/9/20
 **/

@Getter
@Setter
@Embeddable
public class VoyageNumberJpaEntity {

    @Column(name="voyage_number")
    private String voyageNumber;

    public VoyageNumberJpaEntity(String voyageNumber) {
        this.voyageNumber = voyageNumber;
    }

    public VoyageNumberJpaEntity() {

    }


}
