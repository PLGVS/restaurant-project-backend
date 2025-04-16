package com.plgvs.reservas_restaurante.controller;

import com.plgvs.reservas_restaurante.services.EmailSender;
import com.plgvs.reservas_restaurante.domain.Reservation;
import com.plgvs.reservas_restaurante.domain.ReservationRequest;
import com.plgvs.reservas_restaurante.services.ReservationService;
import com.plgvs.reservas_restaurante.exceptions.InvalidReservationTime;
import com.plgvs.reservas_restaurante.exceptions.UnavaialbleTable;
import com.plgvs.reservas_restaurante.repositories.CustomersRepository;
import com.plgvs.reservas_restaurante.repositories.ReservationsRepository;
import com.plgvs.reservas_restaurante.repositories.TablesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/reservation")
public class ScheduleController {
    Map<String, String> response = new HashMap<>();
    private final ReservationService reservationService;
    private final EmailSender emailSender;

    public ScheduleController (ReservationService reservationService, EmailSender emailSender){
        this.reservationService = reservationService;
        this.emailSender = emailSender;
    }

    @Autowired
    private CustomersRepository customersRepository;

    @Autowired
    private TablesRepository tablesRepository;

    @Autowired
    private ReservationsRepository reservationsRepository;
    @PostMapping()
    public Map<String, String> book(@RequestBody ReservationRequest req) throws ParseException {
        try{
            reservationService.bookTable(req);
            System.out.println(req.getRequestDate());
            emailSender.sendEmail(reservationService.getEmail(), reservationService.getEmailPassword(),
                    req.getCustomerEmail(), "Reservation in Savory Heaven", req);

            response.put("message", "Success");
            return response;
        }
        catch (InvalidReservationTime e){
            response.put("message", e.getMessage());
            return response;
        }
        catch (UnavaialbleTable e){
            response.put("message", e.getMessage());
            return response;
        }
    }


    @GetMapping("/search/{id}")
    public String searchReservation(@PathVariable("id") String id){
        Reservation reservationFound = reservationService.searchReservation(id);
        if (reservationFound != null){
            return reservationFound.showReservation();
        }
        return "Reservation not found!";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteReservation(@PathVariable("id") String id){
        Reservation reservationDeleted = reservationService.deleteReservation(id);
        if (reservationDeleted != null){
            return "Reservation canceled successfully: \n" +
                    reservationDeleted.showReservation();
        }
        return "Reservation not found!";
    }
}
