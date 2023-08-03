package com.example.cine;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "peliculas")
public class Pelicula {
    @Id
    private ObjectId id;
    private String imdbId;
    private String trailerLink;
    private String poster;
    private List<String> backdrops;
    private List<Review> reviewIds;
    private String fechaEstreno;
    private List<String> generos;
    private String titulo;

}
