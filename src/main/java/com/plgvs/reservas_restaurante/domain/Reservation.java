package com.plgvs.reservas_restaurante.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.plgvs.reservas_restaurante.exceptions.InvalidReservationDate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Reservation {
    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private static int SEQUENCIAL = 1;
    private int id;
    private String name;
    private String email;
    private int peopleQtt;
    private String table;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime requestDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime reservationDate;

    public Reservation(String name, String email, int peopleQtt, LocalDateTime reservationDate) {
            if (reservationDate.isBefore(LocalDateTime.now())){
                throw new InvalidReservationDate("Reservation date is before the actual date!");
            }
            this.id = SEQUENCIAL++;
            this.name = name;
            this.email = email;
            this.peopleQtt = peopleQtt;
            this.requestDate = LocalDateTime.now();
            this.reservationDate = reservationDate;
            this.table = null;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Reservation that)) return false;
        return Objects.equals(getTable(), that.getTable()) && Objects.equals(getReservationDate(), that.getReservationDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTable(), getReservationDate());
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getPeopleQtt() {
        return peopleQtt;
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public LocalDateTime getRequestDate() {
        return requestDate;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String tableNumber) {
        this.table = tableNumber;
    }

    public String showReservation(){
        return "Reservation number: " + this.id + "\n"
                + "Table number: " + this.table + "\n"
                + "Name: " + this.name + "\n"
                + "Email: " + this.email + "\n"
                + "People quantity: " + this.peopleQtt + "\n"
                + "Request date: " + this.requestDate.format(dtf) + "\n"
                + "Reservation date: " + this.reservationDate.format(dtf);
    }
}
