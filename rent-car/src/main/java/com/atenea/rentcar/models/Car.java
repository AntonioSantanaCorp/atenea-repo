package com.atenea.rentcar.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCar")
    private Integer idCar;
    @Column(name = "name")
    private String name;
    @Column(name = "brand")
    private String brand;
    @Column(name = "year")
    private Integer year;
    @Column(name = "description")
    private String description;
    @Column(name = "model")
    private Integer model;
    @ManyToOne
    @JoinColumn(name = "idGama")
    @JsonIgnoreProperties("cars")
    private Gama gama;

}
