package com.monique.infinitejavascroll.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.monique.infinitejavascroll.R;

public class MainActivity extends AppCompatActivity {

    MoviesRvAdapter moviesAdapter;
    RecyclerView rvMovies;
    MoviesViewModel moviesViewModel = new MoviesViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMovies = findViewById(R.id.rvMovies);
        moviesAdapter = new MoviesRvAdapter(this);
        rvMovies.setAdapter(moviesAdapter);

        moviesViewModel.getPopularMovies(1);
        observeMovies();
    }

    private void observeMovies(){
        moviesViewModel.moviesLiveData.observe(this, result -> {
            if(result != null){
                moviesAdapter.movies.addAll(result);
                moviesAdapter.notifyDataSetChanged();
            }
        });
    }
}