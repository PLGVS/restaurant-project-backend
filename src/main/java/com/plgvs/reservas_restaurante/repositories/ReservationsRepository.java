package com.plgvs.reservas_restaurante.repositories;

import com.plgvs.reservas_restaurante.entities.Reservations;
import com.plgvs.reservas_restaurante.entities.Tables;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationsRepository extends JpaRepository<Reservations, String> {
    List<Reservations> findByTable(Tables table);

    @Query("SELECT r.reservationDate FROM Reservations r")
    List<LocalDateTime> findAllReservationDates();
}
