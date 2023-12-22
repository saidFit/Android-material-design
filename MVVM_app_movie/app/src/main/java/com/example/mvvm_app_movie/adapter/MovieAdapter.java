package com.example.mvvm_app_movie.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mvvm_app_movie.R;
import com.example.mvvm_app_movie.models.MovieModel;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private List<MovieModel> movies;

    public MovieAdapter(List<MovieModel> movies) {
        this.movies = movies;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MovieModel movie = movies.get(position);
        holder.titleTextView.setText(movie.getTitle());
        holder.overviewTextView.setText(movie.getOverview());
        // Load the image using Glide
        Glide.with(holder.itemView.getContext())
                .load("https://image.tmdb.org/t/p/w500" + movie.getBackdropPath())
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public void setMovies(List<MovieModel> movies) {
        this.movies = movies;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView overviewTextView;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.title);
            overviewTextView = itemView.findViewById(R.id.overview);
            imageView = itemView.findViewById(R.id.backdropPath);
        }
    }
}
