package com.example.cine;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cine")
public class PeliculaController {

    @GetMapping
    public ResponseEntity<String> carteleraCompleta() {
        return new ResponseEntity<String>("Todas las peliculas!",HttpStatus.OK);
    }
}