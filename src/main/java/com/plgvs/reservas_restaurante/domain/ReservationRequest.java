package com.plgvs.reservas_restaurante.domain;

import java.time.LocalDateTime;

public class ReservationRequest {
    private String customerName;
    private String customerEmail;
    private int tableNumber;
    private int personsNumber;
    private String reservationDate;
    private String reservationTime;
    private LocalDateTime requestDate = LocalDateTime.now();

    public ReservationRequest(){}

    public ReservationRequest(String customerName, String customerEmail, int tableNumber, int personsNumber, String reservationDate, String reservationTime) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.tableNumber = tableNumber;
        this.personsNumber = personsNumber;
        this.reservationDate = reservationDate;
        this.reservationTime = reservationTime;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public int getPersonsNumber() {
        return personsNumber;
    }

    public void setPersonsNumber(int personsNumber) {
        this.personsNumber = personsNumber;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    public String getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(String reservationTime) {
        this.reservationTime = reservationTime;
    }

    public LocalDateTime getRequestDate() {
        return requestDate;
    }

}
