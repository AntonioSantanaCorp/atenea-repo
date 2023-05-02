package com.atenea.rentcar.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Gama {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idGama")
    private Integer idGama;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = { CascadeType.PERSIST }, mappedBy = "gama")
    @JsonIgnoreProperties("gama")
    @Nullable
    List<Car> cars;
}
