package com.monique.infinitejavascroll.presentation.model;

public class Movie {
    public Movie(String poster, String title) {
        this.poster = poster;
        this.title = title;
    }

    private String poster;
    private String title;

    public String getPoster() {
        return poster;
    }
    public String getTitle() {
        return title;
    }

}
