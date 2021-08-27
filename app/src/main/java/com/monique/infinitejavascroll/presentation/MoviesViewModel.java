package com.monique.infinitejavascroll.presentation;

import androidx.lifecycle.MutableLiveData;

import com.monique.infinitejavascroll.data.repository.MoviesRepositoryImpl;
import com.monique.infinitejavascroll.presentation.model.Movie;
import com.monique.infinitejavascroll.data.repository.MoviesRepository;
import com.monique.infinitejavascroll.presentation.model.Movie;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MoviesViewModel {
    MoviesRepository moviesRepository = new MoviesRepositoryImpl();
    public MutableLiveData<List<Movie>> moviesLiveData = new MutableLiveData<>();

    void getPopularMovies(Integer currentPage){
        moviesRepository.getPopularMovies(currentPage)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(movies -> {
                    moviesLiveData.postValue(movies);
                }).dispose();
    }

}
