package com.example.cine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody, String imdbId){
        Review review = reviewRepository.insert(new Review(reviewBody));

        mongoTemplate.update(Pelicula.class)
                     .matching(Criteria.where("imdbId")
                     .is(imdbId))
                     .apply(new Update().push("reviewIds")
                     .value(review))
                     .first();

        return review;

        //Actualizo una pelicula donde su imdbId (en la DB) coincide con la que recibe por parte del usuario.
        //De esta forma se inserta la nueva review dentro del Array de reviews.
    }
}
