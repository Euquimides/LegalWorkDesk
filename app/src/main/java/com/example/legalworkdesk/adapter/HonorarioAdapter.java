package com.example.legalworkdesk.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.legalworkdesk.R;
import com.example.legalworkdesk.model.Honorario;

import java.util.ArrayList;

public class HonorarioAdapter extends RecyclerView.Adapter<HonorarioAdapter.MyViewHolder> implements View.OnClickListener {

    private ArrayList<Honorario> proceso;

    public HonorarioAdapter(ArrayList<Honorario> proceso) {
        this.proceso = proceso;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView procesoTxT;

        public MyViewHolder(final View view) {
            super(view);
            procesoTxT = view.findViewById(R.id.tvNombreProceso);
        }
    }

    @Override
    public void onClick(View view) {

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewProceso = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_procesos, parent, false);
        return new MyViewHolder(viewProceso);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String nombreProceso = proceso.get(position).getProceso();
        holder.procesoTxT.setText(nombreProceso);

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