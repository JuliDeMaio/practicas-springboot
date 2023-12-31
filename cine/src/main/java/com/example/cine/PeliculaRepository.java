package com.example.cine;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PeliculaRepository extends MongoRepository<Pelicula, ObjectId> {
    Optional<Pelicula> findByImdbId(String imbdId);

}
