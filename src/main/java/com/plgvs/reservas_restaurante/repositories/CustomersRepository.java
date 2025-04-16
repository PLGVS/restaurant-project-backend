package com.plgvs.reservas_restaurante.repositories;

import com.plgvs.reservas_restaurante.entities.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersRepository extends JpaRepository<Customers, String> {
}
