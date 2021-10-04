package com.example.legalworkdesk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {
    private TextView tituloProceso;
    private String nombreProceso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        tituloProceso = findViewById(R.id.tituloProceso);
        nombreProceso = getIntent().getStringExtra("nombreProceso");

        tituloProceso.setText(nombreProceso);
    }
}