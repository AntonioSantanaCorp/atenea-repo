package com.atenea.rentcar.services.Car;
import com.atenea.rentcar.dto.CarDto;
import com.atenea.rentcar.models.Car;
import java.util.List;


public interface CarService {
    public List<Car> getAll();

    public void save(CarDto newCar);

    public void delete(Integer carId);

    public Car getCarById(Integer carId);
}
