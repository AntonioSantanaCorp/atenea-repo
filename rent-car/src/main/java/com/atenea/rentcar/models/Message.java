package com.atenea.rentcar.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMessage")
    private Integer idMessage;
    @Column(name = "idCar")
    private Integer idCar;
    @Column(name = "idClient")
    private Integer idClient;
    @Column(name = "messageText")
    private Integer messageText;
}
