package com.atenea.rentcar.daos;
import org.springframework.data.repository.CrudRepository;
import com.atenea.rentcar.models.Gama;

public interface GamaDao extends CrudRepository<Gama,Integer> {
    
}
