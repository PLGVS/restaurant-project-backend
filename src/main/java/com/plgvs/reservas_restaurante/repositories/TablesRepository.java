package com.plgvs.reservas_restaurante.repositories;

import com.plgvs.reservas_restaurante.entities.Tables;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TablesRepository extends JpaRepository<Tables, Integer> {
    List<Tables> findByTableNumber(int tableNumber);
}
