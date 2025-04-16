package com.plgvs.reservas_restaurante.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.Date;

@Entity
@IdClass(UnavailableTimesId.class)
@Table(name = "unavailable_times", schema = "public")
public class UnavailableTimes {
    @Id
    @Column(name = "time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm", locale = "pt-BR")
    private LocalTime time;

    @Id
    @Column(name = "date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR")
    private Date date;

    @Id
    @ManyToOne
    @JoinColumn(name = "table_number", referencedColumnName = "table_number")
    private Tables table;

    public UnavailableTimes(){}

    public UnavailableTimes(LocalTime time, Date date, Tables table) {
        this.time = time;
        this.date = date;
        this.table = table;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Tables getTable() {
        return table;
    }

    public void setTable(Tables table) {
        this.table = table;
    }
}
