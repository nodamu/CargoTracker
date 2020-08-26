package com.nodamu.cargotracker.booking.domain.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Transient;

/**
 * @author profnick
 * 8/21/20
 **/

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class LastCargoHandledEvent {

    private Integer handlingEventId;

    @Transient
    private String handlingEventType;

    @Transient
    private String handlingEventVoyage;

    @Transient
    private String handlingEventLocation;

    public static final LastCargoHandledEvent EMPTY = new LastCargoHandledEvent();


}
