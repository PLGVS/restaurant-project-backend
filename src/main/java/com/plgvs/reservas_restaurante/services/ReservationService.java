package com.plgvs.reservas_restaurante.services;

import com.plgvs.reservas_restaurante.domain.Reservation;
import com.plgvs.reservas_restaurante.domain.ReservationRequest;
import com.plgvs.reservas_restaurante.entities.Customers;
import com.plgvs.reservas_restaurante.entities.Reservations;
import com.plgvs.reservas_restaurante.entities.Tables;
import com.plgvs.reservas_restaurante.entities.UnavailableTimes;
import com.plgvs.reservas_restaurante.exceptions.InvalidReservationTime;
import com.plgvs.reservas_restaurante.exceptions.UnavaialbleTable;
import com.plgvs.reservas_restaurante.repositories.*;
import com.sun.tools.javac.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class ReservationService {
    SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
    DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm");

    private static Properties props = new Properties();

    @Autowired
    private CustomersRepository customersRepository;

    @Autowired
    private TablesRepository tablesRepository;

    @Autowired
    private ReservationsRepository reservationsRepository;

    @Autowired
    private UnavailableTimesRepository unavailableTimesRepository;

    static {
        try {
            InputStream input = Main.class.getClassLoader().getResourceAsStream("config.properties");
            if (input == null) {
                throw new RuntimeException("Config file not found!");
            }
            props.load(input);
        }
        catch (IOException e){
            throw new RuntimeException("Error loading config file", e);
        }
    }

    private String email = props.getProperty("gmail.email");
    private String emailPassword = props.getProperty("gmail.password");
    Set<Reservation> reservations;

    public ReservationService(){
        this.reservations = new HashSet<>();
    }

    public String getEmail() {
        return email;
    }

    public String getEmailPassword() {
        return emailPassword;
    }

    public void bookTable(ReservationRequest req) throws ParseException {
        Date reservationDate = formatter1.parse(req.getReservationDate());
        LocalTime reservationTime = LocalTime.parse(req.getReservationTime(), formatter2);

        Customers customer = new Customers(req.getCustomerName(), req.getCustomerEmail());
        Tables table = tablesRepository.findById(req.getTableNumber()).orElseThrow(() -> new UnavaialbleTable("Mesa não encontrada"));
        Reservations reservation = new Reservations(customer, table, req.getPersonsNumber(), reservationDate, reservationTime);
        UnavailableTimes unavailableTimes = new UnavailableTimes(reservationTime, reservationDate, table);

        List<UnavailableTimes> times = unavailableTimesRepository.findByTableAndDate(table, reservationDate);
        List<String> validTimes = List.of("17:00", "20:00", "23:00");

        boolean tableAvailable = true;
        if (validTimes.contains(req.getReservationTime())){
            for (UnavailableTimes t : times){
                System.out.println(t.getTime());
                System.out.println(reservationTime);
                if (t.getTime() == reservationTime){
                    System.out.println("Falso");
                    tableAvailable = false;
                    break;
                }
            }
        }
        else {
            throw new InvalidReservationTime("Invalid time!");
        }

        if (tableAvailable){
            customersRepository.save(customer);
            tablesRepository.save(table);
            reservationsRepository.save(reservation);
            unavailableTimesRepository.save(unavailableTimes);
            System.out.println("Reservation saved");
            return;
        }

        throw new InvalidReservationTime("Unavailable table in this time!");


//        for (Reservations r : reservations) {
//            System.out.println("Comparando: " + parsedDate1 + " com " + r.getReservationDate());
//            System.out.println("Table Available? " + tableAvailable);
//            Duration duration = Duration.between(parsedDate1, r.getReservationTime());
//            if (Math.abs(duration.toHours()) < 3) {
//                tableAvailable = false;
//            }
//        }
//
//        if (tableAvailable){
//
//        }
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
