package com.atenea.rentcar.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idReservation")
    private Integer idReservation;
    @Column(name = "idClient")
    private Integer idClient;
    @Column(name = "idCar")
    private Integer idCar;
    @Column(name = "startDate")
    private Date startDate;
    @Column(name = "devolutionDate")
    private Date devolutionDate;
    @Column(name = "status")
    private String status;
}
