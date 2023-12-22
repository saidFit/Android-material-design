package com.example.splashscreen.SliderAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.splashscreen.R;

import java.util.ArrayList;

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Card> cards;

    public SliderAdapter(Context context, ArrayList<Card> cards) {
        this.context = context;
        this.cards = cards;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the appropriate layout based on card type
        int layoutResId;
        switch (viewType) {
            case 1:
                layoutResId = R.layout.recyclerview_data;
                break;
            case 2:
                layoutResId = R.layout.categories_card;
                break;
            default:
                layoutResId = R.layout.most_view_card;
                break;
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutResId, parent, false);
        return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Card card = cards.get(position);

        // Bind data to views
        holder.cardImage.setImageResource(card.getImg());
        holder.cardTitle.setText(card.getTitle());
        holder.cardDescription.setText(card.getDesc());
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView cardImage;
        TextView cardTitle;
        TextView cardDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardImage = itemView.findViewById(R.id.imgCard);
            cardTitle = itemView.findViewById(R.id.textCard);
            cardDescription = itemView.findViewById(R.id.descCard);
        }
    }
}
