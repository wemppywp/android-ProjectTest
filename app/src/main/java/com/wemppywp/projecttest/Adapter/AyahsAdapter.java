package com.wemppywp.projecttest.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wemppywp.projecttest.Model.Ayahs;
import com.wemppywp.projecttest.R;

import java.util.ArrayList;
import java.util.List;

public class AyahsAdapter extends RecyclerView.Adapter<AyahsAdapter.AyahsViewHolder> {

    private ArrayList<Ayahs> ayahsList;
    CardView cardView;

    public AyahsAdapter(ArrayList<Ayahs> ayahsList) {
        this.ayahsList = ayahsList;
    }

    @Override
    public AyahsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_main_containt, parent, false);

        return new AyahsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AyahsViewHolder holder, int position) {
        holder.Text.setText(ayahsList.get(position).getText());
        Log.d("Text", "response:" + ayahsList.get(position).getText());
        holder.numberInSurah.setText(ayahsList.get(position).getNumberInSurah());
        Log.d("numberInSurah", "response:" + ayahsList.get(position).getNumberInSurah());
    }

    @Override
    public int getItemCount() {
        return ayahsList.size();
    }

    public class AyahsViewHolder extends RecyclerView.ViewHolder {

        public TextView Text, numberInSurah;

        public AyahsViewHolder(View view) {
            super(view);
            Text = view.findViewById(R.id.Text);
            numberInSurah = view.findViewById(R.id.numberInSurah);
            cardView = view.findViewById(R.id.card_view);
        }
    }








}
