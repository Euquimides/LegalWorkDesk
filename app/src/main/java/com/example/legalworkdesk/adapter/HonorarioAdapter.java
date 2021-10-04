package com.example.legalworkdesk.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.legalworkdesk.R;
import com.example.legalworkdesk.model.Honorario;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HonorarioAdapter extends RecyclerView.Adapter<HonorarioAdapter.MyViewHolder> implements View.OnClickListener {

    private static FirebaseDatabase firebaseDatabase;
    private static DatabaseReference databaseReference;
    private ArrayList<Honorario> proceso;
    Context context;
    private View.OnClickListener listener;

    public HonorarioAdapter(Context context, ArrayList<Honorario> proceso) {
        this.context = context;
        this.proceso = proceso;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView procesoTxT;

        public MyViewHolder(final View view) {
            super(view);
            procesoTxT = view.findViewById(R.id.tvNombreProceso);
        }
    }

    public void setListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if (listener != null){
            listener.onClick(view);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

        View viewProceso = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_procesos, parent, false);
        viewProceso.setOnClickListener(this);
        return new MyViewHolder(viewProceso);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Honorario nombreProceso = proceso.get(position);
        holder.procesoTxT.setText(nombreProceso.getNombreProceso());

    }

    @Override
    public int getItemCount() {
        return proceso.size();
    }
}

//    Context context;
//    //private List<Honorario> honorarioList;
//    private List<String> honorarioList;
//    private static FirebaseDatabase database;
//    private static DatabaseReference modelRef;
//    private View.OnClickListener listener;
//
//    public HonorarioAdapter(List<String> honorarioList){
//        this.honorarioList = honorarioList;
//    }
//
//    public void setListener(View.OnClickListener listener){
//        this.listener = listener;
//    }
//
//    @Override
//    public void onClick(View view) {
//        if (listener != null){
//            listener.onClick(view);
//        }
//    }
//
//    public void refresh() {
//        honorarioList =  Arrays.asList(new String[]{"Kent", "Juank"});
//    }
//
//    public class MyViewHolder extends RecyclerView.ViewHolder {
//        public EditText etNombreProceso;
//
//        public MyViewHolder(@NonNull View itemView){
//            super(itemView);
//            this.etNombreProceso = itemView.findViewById(R.id.etNombreProceso);
//        }
//    }
//
//    // Create new views (invoked by the layout manager)
//    @NonNull
//    @Override
//    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        database = FirebaseDatabase.getInstance();
//        modelRef = database.getReference();
//
//        View view = LayoutInflater.from(context).inflate(R.layout.card_diligencia, parent, false);
//        view.setOnClickListener(this);
//        return new MyViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull HonorarioAdapter.MyViewHolder holder, int position) {
//        holder.etNombreProceso.setText("hola mundo");
//    }
//
//    @Override
//    public int getItemCount() {
//        return honorarioList.size();
//    }