package com.example.legalworkdesk.ui.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.legalworkdesk.CalculatorActivity;
import com.example.legalworkdesk.R;
import com.example.legalworkdesk.adapter.HonorarioAdapter;
import com.example.legalworkdesk.model.Honorario;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class RecyclerviewFragment extends Fragment {

    private ArrayList<Honorario> proceso;
    private RecyclerView recyclerView;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private HonorarioAdapter honorarioAdapter;

    private void setNombreProceso(){
        DatabaseReference reference = firebaseDatabase.getReference("proceso");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
               for(DataSnapshot dss : snapshot.getChildren()){
                    Honorario nombreProceso = dss.getValue(Honorario.class);
                    proceso.add(nombreProceso);
                }
            honorarioAdapter.notifyDataSetChanged();}

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


//    private void setNombreProceso(){
//        proceso.add(new Honorario("Sumario"));
//        proceso.add(new Honorario("Ordinario"));
//        proceso.add(new Honorario("Arbitral"));
//        proceso.add(new Honorario("Abreviado"));
//        proceso.add(new Honorario("Monitorio"));
//        proceso.add(new Honorario("Interdictal"));
//        proceso.add(new Honorario("Sucesorio"));
//    }

//    private void setAdapter(){
//        HonorarioAdapter honorarioAdapter = new HonorarioAdapter(getContext(), proceso);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext().getApplicationContext());
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(honorarioAdapter);
//
//    }

    private void setHonorarioAdapter(){
        honorarioAdapter = new HonorarioAdapter(getContext(), proceso);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(honorarioAdapter);

        honorarioAdapter.setListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int fila = recyclerView.getChildAdapterPosition(view);
                Honorario honorario = proceso.get(fila);

                Toast.makeText(getContext(), "Su proceso es " + honorario.getNombreProceso(), Toast.LENGTH_SHORT)
                        .show();

                Intent intent = new Intent(getContext(), CalculatorActivity.class);
                intent.putExtra("nombreProceso", honorario.getNombreProceso());
                intent.putExtra("honorario", honorario.getMonto());
                startActivity(intent);
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        recyclerView = view.findViewById(R.id.recyclerview);
        proceso = new ArrayList<>();
        recyclerView.setHasFixedSize(true);
        //honorarioAdapter = new HonorarioAdapter(getContext(), proceso);
        //recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        setNombreProceso();
        //recyclerView.setAdapter(honorarioAdapter);
        //setAdapter();
        setHonorarioAdapter();

        return view;
    }
}

//    private FirebaseDatabase db = FirebaseDatabase.getInstance();
//    private DatabaseReference dbReference = db.getReference().child("abogado");
//    //private ArrayList<Honorario> list = dbReference.child();
//
//    private RecyclerView recyclerView;
//    private HonorarioAdapter adapter;
//    private RecyclerView.LayoutManager layoutManager;
//
//    public View onCreateView (@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//            View view = inflater.inflate(R.layout.fragment_recyclerview, container, false);
//            List<String> list = Arrays.asList(new String[]{"Kent", "Juank"});
//            recyclerView = view.findViewById(R.id.reciclador);
//            layoutManager = new LinearLayoutManager(getContext());
//            adapter = new HonorarioAdapter(list);
//
//            adapter.setListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    int fila = recyclerView.getChildAdapterPosition(v);
//                    String honorario = list.get(fila);
//
//                    Toast.makeText(getContext(), "hola putos", Toast.LENGTH_SHORT).show();
//                }
//            });
//
//            recyclerView.setLayoutManager(layoutManager);
//            recyclerView.setAdapter(adapter);
//            return view;
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        adapter.refresh();
//        adapter.notifyDataSetChanged();
//    }
//}