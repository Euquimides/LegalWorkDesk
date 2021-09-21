package com.example.legalworkdesk.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.legalworkdesk.R;
import com.example.legalworkdesk.model.Honorario;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Arrays;
import java.util.List;

public class HonorarioAdapter extends RecyclerView.Adapter<HonorarioAdapter.HonorarioViewHolder> implements View.OnClickListener {

    Context context;
    //private List<Honorario> honorarioList;
    private List<String> honorarioList;
    private static FirebaseDatabase database;
    private static DatabaseReference modelRef;
    private View.OnClickListener listener;

    public HonorarioAdapter(List<String> honorarioList){
        this.honorarioList = honorarioList;
    }

    public void setListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if (listener != null){
            listener.onClick(view);
        }
    }

    public void refresh() {
        honorarioList =  Arrays.asList(new String[]{"Kent", "Juank"});
    }

    public class HonorarioViewHolder extends RecyclerView.ViewHolder {
        public EditText etNombreProceso;

        public HonorarioViewHolder(@NonNull View itemView){
            super(itemView);
            this.etNombreProceso = itemView.findViewById(R.id.etNombreProceso);
        }
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public HonorarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        database = FirebaseDatabase.getInstance();
        modelRef = database.getReference();

        View view = LayoutInflater.from(context).inflate(R.layout.card_diligencia, parent, false);
        view.setOnClickListener(this);
        return new HonorarioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HonorarioAdapter.HonorarioViewHolder holder, int position) {
        holder.etNombreProceso.setText("hola mundo");
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
