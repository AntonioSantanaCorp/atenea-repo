package com.atenea.rentcar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.atenea.rentcar.models.Car;
import java.util.List;

import com.atenea.rentcar.services.Car.CarService;

@RestController()
@CrossOrigin("*")
@RequestMapping("api/Car/")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping(value = "all")
    public List<Car> get() {
        return carService.getAll();
    }

    @PostMapping(value = "save")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Car> save(@RequestBody Car newCar) {
        Car car = carService.save(newCar);

        return new ResponseEntity<> (car,HttpStatus.OK);
    }
}
