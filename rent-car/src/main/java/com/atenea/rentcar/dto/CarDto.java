package com.atenea.rentcar.dto;

import lombok.Data;

@Data
public class CarDto {
    private String name;
    private String brand;
    private Integer year;
    private String description;
    private CarGamaPayload gama;
}

