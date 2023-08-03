package com.example.cine;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cine")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    @GetMapping
    public ResponseEntity<List<Pelicula>> getCarteleraCompleta() {
        return new ResponseEntity<List<Pelicula>>(peliculaService.getCarteleraCompleta(), HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Pelicula>> getPelicula(@PathVariable String imdbId) {
        return new ResponseEntity<Optional<Pelicula>>(peliculaService.getPelicula(imdbId), HttpStatus.OK);
    }
}