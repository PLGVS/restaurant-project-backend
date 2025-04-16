package com.plgvs.reservas_restaurante.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;

public class UnavailableTimesId implements Serializable {
    private LocalTime time;
    private Date date;
    private Tables table;

    public UnavailableTimesId(){}

    public UnavailableTimesId(LocalTime time, Date date, Tables table) {
        this.time = time;
        this.date = date;
        this.table = table;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof UnavailableTimesId that)) return false;
        return Objects.equals(time, that.time) && Objects.equals(date, that.date) && Objects.equals(table, that.table);
    }

    @Override
    public int hashCode() {
        return Objects.hash(time, date, table);
    }
}
