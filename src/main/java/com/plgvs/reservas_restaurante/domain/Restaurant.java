package com.plgvs.reservas_restaurante.domain;

import com.plgvs.reservas_restaurante.exceptions.UnavaialbleTable;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Restaurant {
    Set<Reservation> reservations;

    public Restaurant(){
        this.reservations = new HashSet<>();
    }

    public void bookTable(Reservation reservation){
        if (reservations.contains(reservation)){
            throw new UnavaialbleTable("This table is already reserved for this day!");
        }
        for (Reservation r : reservations) {
            Duration duration = Duration.between(r.getReservationDate(), reservation.getReservationDate());
            if (Math.abs(duration.toHours()) < 3) {
                throw new UnavaialbleTable("This table is already reserved for this day!");
            }
        }
        reservations.add(reservation);
    }

    public String searchReservation(String id){
        for (Reservation reservation : reservations){
            if (reservation.getId() == Integer.parseInt(id)) {
                return reservation.showReservation();
            }
        }
        return "Reservation not found!";
    }
}
