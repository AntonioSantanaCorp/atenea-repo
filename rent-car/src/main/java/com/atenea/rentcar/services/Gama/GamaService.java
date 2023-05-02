package com.atenea.rentcar.services.Gama;

import java.util.List;

import com.atenea.rentcar.models.Gama;

public interface GamaService {
    public List<Gama> getAll();

    public void save(Gama newGama);

    public void delete(Integer gamaId);

    public Gama getGamaById(Integer gamaId);
}
