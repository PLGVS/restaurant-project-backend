package com.plgvs.reservas_restaurante.domain;

import com.plgvs.reservas_restaurante.exceptions.UnavaialbleTable;

import java.time.Duration;
import java.util.*;

public class Restaurant {
    Set<Reservation> reservations;
    public Restaurant(){
        this.reservations = new HashSet<>();
    }

    public void bookTable(Reservation reservation){
        String [] tables = {"Table 01", "Table 02", "Table 03","Table 04","Table 05","Table 06","Table 07","Table 08","Table 09","Table 10"};
        int i = 0;
        while (i < tables.length){
            String currentTable = tables[i];
            boolean tableAvailable = true;
            reservation.setTable(currentTable);

            if (!reservations.contains(reservation)) {
                for (Reservation r : reservations) {
                    Duration duration = Duration.between(reservation.getReservationDate(), r.getReservationDate());
                    if (r.getTable().equals(reservation.getTable()) && Math.abs(duration.toHours()) <= 3) {
                        tableAvailable = false;
                        break;
                    }
                }
                if (tableAvailable){
                    reservations.add(reservation);
                    return;
                }
            }
            i++;
        }
        throw new UnavaialbleTable("We don't have tables for this day!");
//        if (reservations.contains(reservation)){
//            throw new UnavaialbleTable("This table is already reserved for this day!");
//        }
//        for (Reservation r : reservations) {
//            Duration duration = Duration.between(r.getReservationDate(), reservation.getReservationDate());
//            if (Math.abs(duration.toHours()) < 3) {
//                throw new UnavaialbleTable("This table is already reserved for this day!");
//            }
//        }
//        reservations.add(reservation);
    }

    public Reservation searchReservation(String id){
        for (Reservation reservation : reservations){
            if (reservation.getId() == Integer.parseInt(id)) {
                return reservation;
            }
        }
        return null;
    }

    public Reservation deleteReservation(String id){
        Reservation reservationToDelete = searchReservation(id);
        if (reservationToDelete != null){
            reservations.remove(reservationToDelete);
            return reservationToDelete;
        }
        else {
            return null;
        }
    }

    public void listReservations(){
        for (Reservation r : reservations){
            System.out.println(r.getId());
            System.out.println(r.getTable());
            System.out.println(r.getName());
            System.out.println(r.getPeopleQtt());
            System.out.println(r.getRequestDate());
            System.out.println(r.getReservationDate());
        }
    }
}
