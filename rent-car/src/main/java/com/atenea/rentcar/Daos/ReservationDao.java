package com.atenea.rentcar.daos;
import org.springframework.data.repository.CrudRepository;
import com.atenea.rentcar.models.Reservation;

public interface ReservationDao extends CrudRepository<Reservation, Integer> {
    
}
