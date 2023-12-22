package com.example.mvvm_app_movie.response;

import com.example.mvvm_app_movie.models.MovieModel;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class MovieResponse {
    @SerializedName("results")
    private List<MovieModel> results;

    public List<MovieModel> getResults() {
        return results;
    }


}
