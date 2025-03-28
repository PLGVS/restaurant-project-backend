package com.plgvs.reservas_restaurante.exceptions;

public class InvalidReservationDate extends RuntimeException {
    public InvalidReservationDate(String message) {
        super(message);
    }
}
