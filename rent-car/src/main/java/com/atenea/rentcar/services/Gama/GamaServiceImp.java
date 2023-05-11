package com.atenea.rentcar.services.Gama;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atenea.rentcar.daos.GamaDao;
import com.atenea.rentcar.models.Car;
import com.atenea.rentcar.models.Gama;

@Service
public class GamaServiceImp implements GamaService {
    @Autowired
    private GamaDao gamaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Gama> getAll() {
        List<Gama> gamas = (List<Gama>) this.gamaRepository.findAll();
        gamas.forEach((gama) -> {
            gama.setCars(new ArrayList<Car>());
        });

        return gamas;
    }

    @Override
    @Transactional
    public void save(Gama newGama) {
        this.gamaRepository.save(newGama);
    }

    @Override
    @Transactional
    public void delete(Integer gamaId) {
        this.gamaRepository.deleteById(gamaId);
    }

    @Override
    @Transactional
    public Gama getGamaById(Integer gamaId) {
        return this.gamaRepository.findById(gamaId).orElse(null);
    }

}
