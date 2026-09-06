package com.restaurant.pos.friend2.model;

/**
 * Lifecycle states for a stock Reservation.
 *
 * ACTIVE    -> stock is held/soft-reserved during the 10-minute window
 * RELEASED  -> reservation released back to available stock (order edited down or cancelled)
 * CONFIRMED -> reservation finalized when the order auto-locks after 10 minutes
 */
public enum ReservationStatus {
    ACTIVE,
    RELEASED,
    CONFIRMED
}