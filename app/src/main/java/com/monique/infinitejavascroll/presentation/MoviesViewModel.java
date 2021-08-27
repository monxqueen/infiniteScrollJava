package com.monique.infinitejavascroll.presentation;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.monique.infinitejavascroll.data.repository.MoviesRepositoryImpl;
import com.monique.infinitejavascroll.presentation.model.Movie;
import com.monique.infinitejavascroll.data.repository.MoviesRepository;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MoviesViewModel extends ViewModel {
    MoviesRepository moviesRepository = new MoviesRepositoryImpl();
    public MutableLiveData<List<Movie>> moviesLiveData = new MutableLiveData<>();

    Disposable getPopularMovies(int currentPage){
        return moviesRepository.getPopularMovies(currentPage)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(movies -> moviesLiveData.setValue(movies));
    }
}
