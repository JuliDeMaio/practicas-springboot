package com.example.cine;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaService {

    @Autowired
    private PeliculaRepository peliculaRepository;

    public List<Pelicula> getCarteleraCompleta() {
        return peliculaRepository.findAll();
    }

    public Optional<Pelicula> getPelicula(String imdbId) {
        return peliculaRepository.findByImdbId(imdbId);
    }
}
