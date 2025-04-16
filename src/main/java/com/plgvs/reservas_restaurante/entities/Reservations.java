package com.plgvs.reservas_restaurante.entities;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "reservations", schema = "public")
public class Reservations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "customer_name", referencedColumnName = "name")
    private Customers customerByName;

    @ManyToOne
    @JoinColumn(name = "customer_email", referencedColumnName = "email")
    private Customers customerByEmail;

    @ManyToOne
    @JoinColumn(name = "table_number", referencedColumnName = "table_number")
    private Tables table;

    @Column(name = "persons_number")
    private int personsNumber;

    @Column(name = "reservation_date")
    private Date reservationDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm", locale = "pt-BR")
    @Column(name = "reservation_time")
    private LocalTime reservationTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm", locale = "pt-BR")
    @Column(name = "request_date")
    private LocalDateTime requestDate;

    public Reservations(){}

    public Reservations(Customers customer, Tables table, int personsNumber, Date reservationDate, LocalTime reservationTime) {
        this.customerByName = customer;
        this.customerByEmail = customer;
        this.table = table;
        this.personsNumber = personsNumber;
        this.requestDate = LocalDateTime.now();
        this.reservationDate = reservationDate;
        this.reservationTime = reservationTime;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Tables getTable() {
        return table;
    }

    public void setTable(Tables table) {
        this.table = table;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public LocalTime getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(LocalTime reservationTime) {
        this.reservationTime = reservationTime;
    }

    public LocalDateTime getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDateTime requestDate) {
        this.requestDate = requestDate;
    }
}
