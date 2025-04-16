package com.plgvs.reservas_restaurante.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tables", schema = "public")
public class Tables {
    @Id
    @Column(name = "table_number")
    private int tableNumber;

    public Tables(){}

    public Tables(int table_number) {
        this.tableNumber = table_number;
    }

    public int getTable_number() {
        return tableNumber;
    }

    public void setTable_number(int table_number) {
        this.tableNumber = table_number;
    }
}
