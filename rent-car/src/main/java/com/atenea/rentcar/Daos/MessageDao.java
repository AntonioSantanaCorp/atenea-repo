package com.atenea.rentcar.daos;
import org.springframework.data.repository.CrudRepository;
import com.atenea.rentcar.models.Message;


public interface MessageDao extends CrudRepository<Message, Integer> {

}
