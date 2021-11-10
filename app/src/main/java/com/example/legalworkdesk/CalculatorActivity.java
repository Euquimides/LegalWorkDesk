package com.example.legalworkdesk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private TextView tituloProceso;
    private TextView tvMontoHonorario;
    private TextView tvTimbre;
    private TextView tvTotal;
    private EditText etPrecio;
    private Spinner spinner;
    private Button btCalcular;

    private String nombreProceso;
    private long sumaHonorarioIVA;
    private long honorario;
    private long timbre;
    private long precio;
    private long total;
    private boolean isSelected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        tituloProceso = findViewById(R.id.tituloProceso);
        tvMontoHonorario = findViewById(R.id.tvMontoHonorario);
        tvTimbre = findViewById(R.id.tvTimbre);
        etPrecio = (EditText) findViewById(R.id.etPrecio);
        tvTotal = findViewById(R.id.tvTotal);
        btCalcular = findViewById(R.id.btCalcular);

        //Se obtiene la información del RecyclerFragment
        nombreProceso = getIntent().getStringExtra("nombreProceso");
        honorario = getIntent().getLongExtra("honorario",0);

        //Set de la info obtenida de RecyclerFragment
        tituloProceso.setText(nombreProceso);
        tvMontoHonorario.setText(Long.toString(honorario));

        //Se crea un Spinner Adapter
        spinner = findViewById(R.id.ivaSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.iva_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    calcularTotal();
                }catch (Exception e){
                    etPrecio.setError("Agregue un monto");
                }
            }
        });

//        etPrecio.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//            //No quitarle el try & catch, no sé como sirve pero sirve (sospecho es por el numericexception)
//            @Override
//            public void afterTextChanged(Editable editable) {
//                if (!etPrecio.equals("") || etPrecio.equals("0")){
//                    try {
//                        total();
//                    } catch (NumberFormatException e) {
//                        e.printStackTrace();
//                    }
//                } else {
//                    Toast.makeText(getApplicationContext(), "Por favor ingrese un monto",
//                            Toast.LENGTH_SHORT).show();
//                }
//            }
//        });


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        isSelected = true;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    public long setTimbre (){
        precio = Long.parseLong(etPrecio.getText().toString());

        if (precio <= 250000){
            timbre = 0;
            tvTimbre.setText(Long.toString(timbre));
        }else if (precio > 250000 && precio < 1000000){
            timbre = 1100;
            tvTimbre.setText(Long.toString(timbre));
        }else if (precio > 1000000 && precio < 5000000){
            timbre = 2200;
            tvTimbre.setText(Long.toString(timbre));
        }else if (precio > 5000000 && precio < 25000000){
            timbre = 5500;
            tvTimbre.setText(Long.toString(timbre));
        }else if (precio > 25000000 && precio < 50000000){
            timbre = 11000;
            tvTimbre.setText(Long.toString(timbre));
        }else if (precio > 50000000 && precio < 100000000){
            timbre = 16500;
            tvTimbre.setText(Long.toString(timbre));
        }else if (precio > 100000000 && precio < 500000000){
            timbre = 16500;
            tvTimbre.setText(Long.toString(timbre));
        }else if (precio >= 500000000){
            timbre = 55000;
            tvTimbre.setText(Long.toString(timbre));
        }else {
            timbre = 12100;
            tvTimbre.setText(Long.toString(timbre));
        }
        return timbre;
    }


    public void calcularTotal(){
        setTimbre();
        precio = Long.parseLong(etPrecio.getText().toString());
        long sinIVA;

        try {
            if (precio <= 16000000 && isSelected == true){
                if (Integer.parseInt(spinner.getSelectedItem().toString()) == 13){
                    sinIVA = (long) (precio * 0.20);
                    total = (long) (sinIVA + (precio * 0.13) + setTimbre());
                    tvTotal.setText(String.valueOf(total));
                }else if (Integer.parseInt(spinner.getSelectedItem().toString()) == 2){
                    sinIVA = (long) (precio * 0.20);
                    total = (long) (sinIVA + (precio * 0.2) + setTimbre());
                    tvMontoHonorario.setText(String.valueOf(sinIVA));
                    tvTotal.setText(String.valueOf(total));
                }else if (Integer.parseInt(spinner.getSelectedItem().toString()) == 0){
                    sinIVA = (long) (precio * 0.20);
                    total = (long) (sinIVA + setTimbre());
                    tvMontoHonorario.setText(String.valueOf(sinIVA));
                    tvTotal.setText(String.valueOf(total));
                }
            }else if (precio > 16000000 && precio < 82500000 && isSelected == true){
                if (Integer.parseInt(spinner.getSelectedItem().toString()) == 13){
                    sinIVA = (long) (precio * 0.15);
                    total = (long) (sinIVA + (precio * 0.13) + setTimbre());
                    tvMontoHonorario.setText(String.valueOf(sinIVA));
                    tvTotal.setText(String.valueOf(total));
                }else if (Integer.parseInt(spinner.getSelectedItem().toString()) == 2){
                    sinIVA = (long) (precio * 0.15);
                    total = (long) (sinIVA + (precio * 0.2) + setTimbre());
                    tvMontoHonorario.setText(String.valueOf(sinIVA));
                    tvTotal.setText(String.valueOf(total));
                }else if (Integer.parseInt(spinner.getSelectedItem().toString()) == 0){
                    sinIVA = (long) (precio * 0.15);
                    total = (long) (sinIVA + setTimbre());
                    tvMontoHonorario.setText(String.valueOf(sinIVA));
                    tvTotal.setText(String.valueOf(total));
                }
            }else if (precio > 82500000 && isSelected == true){
                if (Integer.parseInt(spinner.getSelectedItem().toString()) == 13){
                    sinIVA = (long) (precio * 0.10);
                    total = (long) (sinIVA + (precio * 0.13) + setTimbre());
                    tvMontoHonorario.setText(String.valueOf(sinIVA));
                    tvTotal.setText(String.valueOf(total));
                }else if (Integer.parseInt(spinner.getSelectedItem().toString()) == 2){
                    sinIVA = (long) (precio * 0.10);
                    total = (long) (sinIVA + (precio * 0.2) + setTimbre());
                    tvMontoHonorario.setText(String.valueOf(sinIVA));
                    tvTotal.setText(String.valueOf(total));
                }else if (Integer.parseInt(spinner.getSelectedItem().toString()) == 0){
                    sinIVA = (long) (precio * 0.10);
                    total = (long) (sinIVA + setTimbre());
                    tvMontoHonorario.setText(String.valueOf(sinIVA));
                    tvTotal.setText(String.valueOf(total));
                }
            }else if (isSelected == false){
                Toast.makeText(getApplicationContext(), "Agregue un monto y seleccione IVA",
                        Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}