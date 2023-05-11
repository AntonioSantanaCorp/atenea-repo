package com.atenea.rentcar.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "adminUser")
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
