package com.atenea.rentcar.Daos;
import org.springframework.data.repository.CrudRepository;
import com.atenea.rentcar.models.Reservation;

public interface ReservationDao extends CrudRepository<Reservation, Integer> {
    
}
