package com.nodamu.cargotracker.booking.domain.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author profnick
 * 8/21/20
 **/

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LastCargoHandledEvent {
    private Integer handlingEventId;
    private String handlingEventType;
    private String handlingEventVoyage;
    private String handlingEventLocation;

    public static final LastCargoHandledEvent EMPTY = new LastCargoHandledEvent();


}
