package com.example.mvvm_app_movie.viewModel;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvm_app_movie.models.MovieModel;
import com.example.mvvm_app_movie.request.Service;
import com.example.mvvm_app_movie.response.MovieResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieViewModel extends ViewModel {
    private MutableLiveData<List<MovieModel>> moviesLiveData = new MutableLiveData<>();
    private final String BASE_URL = "https://api.themoviedb.org/3/";
    private final String API_KEY = "d6d910462a1506c4133bc97f7b8a3cf4";

    public LiveData<List<MovieModel>> getMoviesLiveData() {
        return moviesLiveData;
    }

    public void fetchMovies() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Service movieService = retrofit.create(Service.class);
        Call<MovieResponse> call = movieService.getPopularMovies(API_KEY);

        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful()) {
                    List<MovieModel> movies = response.body().getResults();
                    Log.d("items", "onResponse: "+movies);
                    moviesLiveData.postValue(movies);
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                // Log the error for debugging purposes
                Log.e("MovieViewModel", "Network request failed: " + t.getMessage());

                // Update the UI to show an error message to the user
                // You can use a Toast, Snackbar, or any other UI element for this purpose
                // For example, using a Toast message:
                String errorMessage = "Network request failed. Please check your internet connection.";
//                Toast.makeText(applicationContext, errorMessage, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
