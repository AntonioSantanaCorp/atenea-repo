package com.atenea.rentcar.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@CrossOrigin("*")
@RequestMapping("api/Test/")
public class TestController {
    @GetMapping(value = "all")
    public String get() {
        return "<h1>Hola mundo</h1>";
    }
}
