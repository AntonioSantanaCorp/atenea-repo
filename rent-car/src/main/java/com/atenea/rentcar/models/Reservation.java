package com.atenea.rentcar.models;

import java.util.Date;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
