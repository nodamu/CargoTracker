package com.nodamu.cargotracker.booking.domain.valueobjects;

/**
 * @author profnick
 * 8/21/20
 **/

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Voyage value object
 * Id
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Voyage {
    private String voyageNumber;
}
