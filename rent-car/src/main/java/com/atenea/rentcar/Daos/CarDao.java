package com.atenea.rentcar.Daos;
import org.springframework.data.repository.CrudRepository;
import com.atenea.rentcar.models.Car;

public interface CarDao extends CrudRepository<Car, Integer> {

}
