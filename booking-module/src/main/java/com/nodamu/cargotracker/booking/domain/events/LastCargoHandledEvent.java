package com.nodamu.cargotracker.booking.domain.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author profnick
 * 8/20/20
 **/

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LastCargoHandledEvent {
    private Integer handlingEventId;
    private String handlingEventType;
    private String handlingEventVoyage;
    private String handlingEventLocation;
    // Null object pattern.
    public static final LastCargoHandledEvent EMPTY = new LastCargoHandledEvent();


}
