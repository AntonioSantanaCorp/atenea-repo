package com.atenea.rentcar.models;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
