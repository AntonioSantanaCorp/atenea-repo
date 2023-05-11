package com.atenea.rentcar.models;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMessage")
    private Integer idMessage;
    @Column(name = "idClient")
    private Integer idClient;
    @Column(name = "messageText")
    private Integer messageText;
    @OneToOne
    @JoinColumn(name = "idCar")
    @JsonIgnoreProperties("messages")
    private Car car;
}
