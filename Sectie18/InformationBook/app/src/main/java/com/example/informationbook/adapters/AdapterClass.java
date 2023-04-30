package com.example.informationbook.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.informationbook.ModelClass;
import com.example.informationbook.R;
import com.example.informationbook.activites.CountriesActivity;
import com.example.informationbook.activites.LeadersActivity;
import com.example.informationbook.activites.MuseumsActivity;
import com.example.informationbook.activites.WondersActivity;

import java.util.ArrayList;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.CardViewHolder> {

    private final ArrayList<ModelClass> modelList;
    private final Context context;

    public AdapterClass(ArrayList<ModelClass> modelList, Context context) {
        this.modelList = modelList;
        this.context = context;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_design, parent, false);

        return new CardViewHolder(view);
    }

    @SuppressLint("DiscouragedApi")
    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        ModelClass model = modelList.get(position);
        holder.textViewSplash.setText(model.getCategoryName());
        holder.imageViewSplash.setImageResource(context.getResources()
                .getIdentifier(model.getImageName(), "drawable", context.getPackageName()));

        holder.cardView.setOnClickListener(v -> {

            Intent intent = null;

            if (position == 0) intent = new Intent(context, CountriesActivity.class);
            if (position == 1) intent = new Intent(context, LeadersActivity.class);
            if (position == 2) intent = new Intent(context, MuseumsActivity.class);
            if (position == 3) intent = new Intent(context, WondersActivity.class);

            if (intent != null) {
                context.startActivity(intent);
            }

        });

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imageViewSplash;
        private final TextView textViewSplash;
        private final CardView cardView;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewSplash = itemView.findViewById(R.id.imageViewSplash);
            textViewSplash = itemView.findViewById(R.id.textViewSplash);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
