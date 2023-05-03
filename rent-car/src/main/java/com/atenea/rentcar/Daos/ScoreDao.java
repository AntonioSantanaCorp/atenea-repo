package com.atenea.rentcar.daos;
import org.springframework.data.repository.CrudRepository;
import com.atenea.rentcar.models.Score;

public interface ScoreDao extends CrudRepository<Score,Integer>{
    
}
