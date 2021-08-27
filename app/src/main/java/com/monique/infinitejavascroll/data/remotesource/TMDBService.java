package com.monique.infinitejavascroll.data.remotesource;

import com.monique.infinitejavascroll.data.models.MovieListResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TMDBService {
    @GET("movie/popular")
    Single<MovieListResponse> getPopularMovies(@Query("page") Integer currentPage);
}
