package com.nodamu.cargotracker.booking.domain.valueobjects;

/**
 * @author profnick
 * 8/21/20
 **/

/**
 * Enum class for Transport Status of the Cargo
 */
public enum TransportStatus {
    NOT_RECEIVED,
    IN_PORT,
    ONBOARD_CARRIER,
    CLAIMED,
    UNKNOWN;
}
