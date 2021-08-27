package com.monique.infinitejavascroll.data.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieListResponse {
    @SerializedName("results")
    public List<MovieResponse> movieResults;
}
