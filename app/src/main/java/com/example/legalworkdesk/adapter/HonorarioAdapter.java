package com.example.legalworkdesk.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HonorarioAdapter extends RecyclerView.Adapter<HonorarioAdapter.HonorarioViewHolder> implements View.OnClickListener {

    Context context;
    private static FirebaseDatabase database;
    private static DatabaseReference modelRef;



    @Override
    public void onClick(View view) {

    }

    @NonNull
    @Override
    public HonorarioAdapter.HonorarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull HonorarioAdapter.HonorarioViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
