package com.monique.infinitejavascroll.presentation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.monique.infinitejavascroll.R;

public class MainActivity extends AppCompatActivity {

    MoviesRvAdapter moviesAdapter;
    RecyclerView rvMovies;
    LinearLayoutManager rvLayoutManager;
    MoviesViewModel moviesViewModel = new MoviesViewModel();
    private boolean loading = true;
    int pageCount = 1;
    int pastVisibleItems, visibleItemCount, totalItemCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMovies = findViewById(R.id.rvMovies);
        moviesAdapter = new MoviesRvAdapter(this);
        rvMovies.setAdapter(moviesAdapter);
        rvLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rvMovies.setLayoutManager(rvLayoutManager);

        rvMovies.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if(dx > 0){
                    visibleItemCount = rvLayoutManager.getChildCount();
                    totalItemCount = rvLayoutManager.getItemCount();
                    pastVisibleItems = rvLayoutManager.findFirstVisibleItemPosition();

                    if(loading){
                        if((visibleItemCount + pastVisibleItems) >= totalItemCount){
                            loading = false;
                            moviesViewModel.getPopularMovies(pageCount+1);
                            pageCount++;
                            loading = true;
                        }
                    }

                }
            }
        });

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