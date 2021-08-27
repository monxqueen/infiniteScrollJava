package com.monique.infinitejavascroll.data.repository;

import com.monique.infinitejavascroll.data.base.Network;
import com.monique.infinitejavascroll.data.mapper.MovieMapper;
import com.monique.infinitejavascroll.data.remotesource.TMDBService;
import com.monique.infinitejavascroll.presentation.model.Movie;

import java.util.List;

import io.reactivex.Single;

public class MoviesRepositoryImpl implements MoviesRepository {
    private TMDBService moviesRemoteSource = Network.getMoviesService();
    private MovieMapper movieMapper = new MovieMapper();

    @Override
    public Single<List<Movie>> getPopularMovies(Integer currentPage) {
        return moviesRemoteSource.getPopularMovies(currentPage)
                .map( movieListResponse ->
                        movieMapper.map(movieListResponse.movieResults)
                );
    }
}
