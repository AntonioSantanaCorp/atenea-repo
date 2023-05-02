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
@Table(name = "")
public class AdminUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCar")
    private Integer idAdmin;
    @Column(name = "name")
    private Integer name;
    @Column(name = "email")
    private Integer email;
    @Column(name = "password")
    private Integer password;
}
