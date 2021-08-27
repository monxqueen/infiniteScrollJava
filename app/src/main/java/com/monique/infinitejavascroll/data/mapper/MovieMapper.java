package com.monique.infinitejavascroll.data.mapper;

import com.monique.infinitejavascroll.data.models.MovieResponse;
import com.monique.infinitejavascroll.presentation.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieMapper {
    public List<Movie> map(List<MovieResponse> movieResponseList) {
        List<Movie> movies = new ArrayList<>();
        movieResponseList.forEach(movieResponse -> {
            Movie movie = new Movie(movieResponse.getPoster(), movieResponse.getTitle());
            movies.add(movie);
        });
        return movies;
    }
}
