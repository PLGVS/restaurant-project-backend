package com.plgvs.reservas_restaurante.controller;

import com.plgvs.reservas_restaurante.domain.Reservation;
import com.plgvs.reservas_restaurante.domain.Restaurant;
import com.plgvs.reservas_restaurante.exceptions.InvalidReservationDate;
import com.plgvs.reservas_restaurante.exceptions.UnavaialbleTable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservation")
public class ScheduleController {
    Restaurant restaurant = new Restaurant();
    @PostMapping()
    public String book(@RequestBody Reservation reservation){
        try{
            restaurant.bookTable(reservation);
            return reservation.showReservation();
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
        return restaurant.searchReservation(id);
    }
}
