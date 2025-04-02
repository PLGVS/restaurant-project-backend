package com.plgvs.reservas_restaurante.controller;

import com.plgvs.reservas_restaurante.domain.Reservation;
import com.plgvs.reservas_restaurante.domain.Restaurant;
import com.plgvs.reservas_restaurante.exceptions.InvalidReservationDate;
import com.plgvs.reservas_restaurante.exceptions.UnavaialbleTable;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/reservation")
public class ScheduleController {
    Restaurant restaurant = new Restaurant();
    @PostMapping()
    public String book(@RequestBody Reservation reservation){
        try{
            restaurant.bookTable(reservation);
            System.out.println(reservation.showReservation());
            return "Success";
        }
        catch (InvalidReservationDate e){
            return "Invalid date: " + e.getMessage();
        }
        catch (UnavaialbleTable e){
            return e.getMessage();
        }
    }

    @GetMapping("/search/{id}")
    public String searchReservation(@PathVariable("id") String id){
        Reservation reservationFound = restaurant.searchReservation(id);
        if (reservationFound != null){
            return reservationFound.showReservation();
        }
        return "Reservation not found!";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteReservation(@PathVariable("id") String id){
        Reservation reservationDeleted = restaurant.deleteReservation(id);
        if (reservationDeleted != null){
            return "Reservation canceled successfully: \n" +
                    reservationDeleted.showReservation();
        }
        return "Reservation not found!";
    }
}
