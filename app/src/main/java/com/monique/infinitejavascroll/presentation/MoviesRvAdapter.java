package com.monique.infinitejavascroll.presentation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.monique.infinitejavascroll.presentation.model.Movie;

import java.util.ArrayList;
import java.util.List;

import com.monique.infinitejavascroll.R;


public class MoviesRvAdapter extends RecyclerView.Adapter<MoviesRvAdapter.ViewHolder> {
    public List<Movie> movies = new ArrayList<>();
    private Context context;

    public MoviesRvAdapter(Context context) {
        this.context = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgMovie;
        public TextView titleMovie;

        public ViewHolder(View view){
            super(view);
            this.imgMovie = view.findViewById(R.id.imgMovie);
            this.titleMovie = view.findViewById(R.id.titleMovie);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View layoutInflater = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(layoutInflater);
    }

    @Override
    public void onBindViewHolder( MoviesRvAdapter.ViewHolder holder, int position) {
        Glide.with(context).load("https://image.tmdb.org/t/p/w500" + movies.get(position).getPoster()).into(holder.imgMovie);
        holder.titleMovie.setText(movies.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}
