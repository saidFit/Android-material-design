package com.example.mvvm_app_movie;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvm_app_movie.adapter.MovieAdapter;
import com.example.mvvm_app_movie.models.MovieModel;
import com.example.mvvm_app_movie.viewModel.MovieViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final int INTERNET_PERMISSION_REQUEST_CODE = 1;
    private MovieViewModel movieViewModel;
    private RecyclerView recyclerView;
    private MovieAdapter movieAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        movieViewModel = new ViewModelProvider(this).get(MovieViewModel.class);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        movieAdapter = new MovieAdapter(new ArrayList<>());
        recyclerView.setAdapter(movieAdapter);

        movieViewModel.getMoviesLiveData().observe(this, new Observer<List<MovieModel>>() {
            @Override
            public void onChanged(List<MovieModel> movies) {
                Log.d("data", String.valueOf(movies));
                movieAdapter.setMovies(movies);
            }
        });

        movieViewModel.fetchMovies();
    }
}
