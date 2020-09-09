package com.nodamu.routingservice.adapters.out.persistence.jpaentities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author profnick
 * 9/9/20
 **/

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class LocationJpaEntity {

    @Column(name = "arrival_location_id")
    private String unLocCode;

}
