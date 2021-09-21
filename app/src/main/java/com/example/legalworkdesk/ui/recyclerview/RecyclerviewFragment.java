package com.example.legalworkdesk.ui.recyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.legalworkdesk.R;
import com.example.legalworkdesk.adapter.HonorarioAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Arrays;
import java.util.List;

public class RecyclerviewFragment extends Fragment {

    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference dbReference = db.getReference().child("abogado");
    //private ArrayList<Honorario> list = dbReference.child();

    private RecyclerView recyclerView;
    private HonorarioAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;


    public View onCreateView (@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        List<String> list = Arrays.asList(new String[]{"Kent", "Juank"});
        recyclerView = new RecyclerView(getContext());
        recyclerView = recyclerView.findViewById(R.id.reciclador);
        layoutManager = new LinearLayoutManager(getContext());
        adapter = new HonorarioAdapter(list);

        adapter.setListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int fila = recyclerView.getChildAdapterPosition(v);
                String honorario = list.get(fila);

                Toast.makeText(getContext(), "hola putos", Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        View root = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        adapter.refresh();
        adapter.notifyDataSetChanged();
    }
}
