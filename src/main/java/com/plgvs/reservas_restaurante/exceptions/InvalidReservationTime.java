package com.plgvs.reservas_restaurante.exceptions;

public class InvalidReservationTime extends RuntimeException {
    public InvalidReservationTime(String message) {
        super(message);
    }
}
