package com.plgvs.reservas_restaurante.exceptions;

public class UnavaialbleTable extends RuntimeException {
    public UnavaialbleTable(String message) {
        super(message);
    }
}
