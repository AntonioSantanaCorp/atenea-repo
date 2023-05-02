package com.atenea.rentcar.Daos;
import org.springframework.data.repository.CrudRepository;
import com.atenea.rentcar.models.Client;

public interface ClientDao extends CrudRepository<Client,Integer> {
    
}
