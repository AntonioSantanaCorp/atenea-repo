package com.atenea.rentcar.Daos;
import org.springframework.data.repository.CrudRepository;
import com.atenea.rentcar.models.Score;

public interface ScoreDao extends CrudRepository<Score,Integer>{
    
}
