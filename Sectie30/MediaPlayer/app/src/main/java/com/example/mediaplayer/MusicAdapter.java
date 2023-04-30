package com.example.mediaplayer;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MusicViewHolder> {

    ArrayList<String> list;
    Context mContext;

    public MusicAdapter(ArrayList<String> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MusicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_music,parent,false);

        return new MusicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicViewHolder holder, final int position) {

        final String filePath = list.get(position);

        Log.e("filepath : ",filePath);

        final String title = filePath.substring(filePath.lastIndexOf("/") + 1);

        holder.textViewFileName.setText(title);

        holder.cardView.setOnClickListener(v -> {
            Intent intent = new Intent(mContext, MusicActivity.class);
            intent.putExtra("title",title);
            intent.putExtra("filepath",filePath);
            intent.putExtra("position",position);
            intent.putExtra("list",list);

            mContext.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MusicViewHolder extends RecyclerView.ViewHolder {

        private final TextView textViewFileName;
        private final CardView cardView;

        public MusicViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewFileName = itemView.findViewById(R.id.textViewFileName);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
