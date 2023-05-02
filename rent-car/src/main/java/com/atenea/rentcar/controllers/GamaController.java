package com.atenea.rentcar.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atenea.rentcar.models.Gama;
import com.atenea.rentcar.services.Gama.GamaService;

@RestController()
@CrossOrigin("*")
@RequestMapping("api/Gama/")
public class GamaController {
    
    @Autowired
    private GamaService gamaService; 

    @GetMapping(value = "all")
    public List<Gama> get() {
        return gamaService.getAll();
    }

    @PostMapping(value = "save")
    public void save(@RequestBody Gama newGama) {
         gamaService.save(newGama);
    }
}
