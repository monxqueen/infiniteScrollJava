package com.monique.infinitejavascroll.data.repository;

import com.monique.infinitejavascroll.presentation.model.Movie;

import java.util.List;

import io.reactivex.Single;

public interface MoviesRepository {
    Single<List<Movie>> getPopularMovies(Integer currentPage);
}
