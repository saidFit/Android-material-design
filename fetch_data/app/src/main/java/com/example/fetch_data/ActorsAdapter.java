package com.example.fetch_data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.fetch_data.ActorModel;
import com.example.fetch_data.R;
import java.util.List;

public class ActorsAdapter extends RecyclerView.Adapter<ActorsAdapter.ViewHolder> {
    private List<ActorModel> actors;
    private Context context;

    public ActorsAdapter(Context context, List<ActorModel> actors) {

        this.actors = actors;
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_view_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
                ActorModel actor = actors.get(position);
        holder.titleTextView.setText(actor.getName());
        holder.overviewTextView.setText(actor.getOverView());
        // Load the image using Glide
        Glide.with(context)
                .load(actor.getImg())
                .into(holder.imageView);
    }



    @Override
    public int getItemCount() {
        return actors.size();
    }

//    public void setMovies(List<MovieModel> movies) {
//        this.movies = movies;
//    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView overviewTextView;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.name);
            overviewTextView = itemView.findViewById(R.id.overView);
            imageView = itemView.findViewById(R.id.imgUrl);
        }
    }
}
