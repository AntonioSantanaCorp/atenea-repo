package com.atenea.rentcar.daos;
import org.springframework.data.repository.CrudRepository;
import com.atenea.rentcar.models.AdminUser;

public interface AdminUserDao extends CrudRepository<AdminUser,Integer>{
    
}
