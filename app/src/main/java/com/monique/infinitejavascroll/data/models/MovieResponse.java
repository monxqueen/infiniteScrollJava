package com.monique.infinitejavascroll.data.models;

import com.google.gson.annotations.SerializedName;

public class MovieResponse {
    @SerializedName("poster_path")
    String poster;
    @SerializedName("title")
    String title;

    public String getPoster() {
        return poster;
    }
    public String getTitle() {
        return title;
    }
}
