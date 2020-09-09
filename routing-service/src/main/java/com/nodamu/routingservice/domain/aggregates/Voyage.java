package com.nodamu.routingservice.domain.aggregates;

import com.nodamu.routingservice.domain.valueobjects.Schedule;
import com.nodamu.routingservice.domain.valueobjects.VoyageNumber;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author profnick
 * 9/9/20
 **/

@Data
@NoArgsConstructor
public class Voyage {
    private Schedule schedule;
    private VoyageNumber voyageNumber;
}
