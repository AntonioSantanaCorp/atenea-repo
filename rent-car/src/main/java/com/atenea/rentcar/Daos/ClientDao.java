package com.atenea.rentcar.daos;
import org.springframework.data.repository.CrudRepository;
import com.atenea.rentcar.models.Client;

public interface ClientDao extends CrudRepository<Client,Integer> {
    
}
