package com.plgvs.reservas_restaurante.repositories;

import com.plgvs.reservas_restaurante.entities.Tables;
import com.plgvs.reservas_restaurante.entities.UnavailableTimes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface UnavailableTimesRepository extends JpaRepository<UnavailableTimes, String> {
    List<UnavailableTimes> findByTableAndDate(Tables table, Date date);
}
