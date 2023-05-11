package com.atenea.rentcar.services.Car;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atenea.rentcar.daos.CarDao;
import com.atenea.rentcar.dto.CarDto;
import com.atenea.rentcar.models.Car;
import com.atenea.rentcar.models.Gama;
import com.atenea.rentcar.models.Message;
import com.atenea.rentcar.models.Reservation;

@Service
public class CarServiceImp implements CarService {
    @Autowired
    private CarDao carRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Car> getAll() {
        List<Car> cars = (List<Car>) this.carRepository.findAll();
        cars.forEach(car -> {
            car.setReservations(new ArrayList<Reservation>());
            car.setMessages(new ArrayList<Message>());
        });
        return (List<Car>) this.carRepository.findAll();
    }

    @Override
    @Transactional
    public void save(CarDto newCar) {
        Car car = new Car();
        car.setName(newCar.getName());
        car.setBrand(newCar.getBrand());
        car.setYear(newCar.getYear());
        car.setDescription(newCar.getDescription());
        // Gama
        Gama gamaPayload = new Gama();
        gamaPayload.setIdGama(newCar.getGama().getIdGama());
        car.setGama(gamaPayload);

        this.carRepository.save(car);
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
