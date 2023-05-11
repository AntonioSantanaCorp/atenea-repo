package com.atenea.rentcar.services.Car;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atenea.rentcar.daos.CarDao;
import com.atenea.rentcar.models.Car;

@Service
public class CarServiceImp implements CarService {
    @Autowired
    private CarDao carRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Car> getAll() {
        return (List<Car>) this.carRepository.findAll();
    }

    @Override
    @Transactional
    public Car save(Car newCar) {
       return this.carRepository.save(newCar);
    }

    @Override
    @Transactional
    public void delete(Integer carId) {
        this.carRepository.deleteById(carId);
    }

    @Override
    @Transactional(readOnly = true)
    public Car getCarById(Integer carId) {
        return this.carRepository.findById(carId).orElse(null);
    }
}
