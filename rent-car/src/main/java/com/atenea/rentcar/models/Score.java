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
@Table(name="score")
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idScore")
    private Integer idScore;
    @Column(name = "idReservation")
    private Integer idReservation;
    @Column(name = "name")
    private Integer name;
    @Column(name = "score")
    private Integer score;
}
