package com.example.legalworkdesk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private EditText etCorreo;
    private EditText etClave;

    public static FirebaseAuth mAuth;

    @Override
    //Crea la vista 
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCorreo=findViewById(R.id.etCorreo);
        etClave=findViewById(R.id.etClave);

        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    // Se llama al iniciar la vista
    // Se busca el usuario en firebase
    public void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        updateUI(user);
    }

    // Verifica que la clave cumpla con los requisitos
    public String verificarClave(String clave) {
        String error = "";
        if (clave.length() < 8 ){
            error += "Debe tener al menos 8 caracteres";
        } else {
            error += "Por favor escriba un correo valido";
        }
        return error;
    }

    //Verifica que los campos no estén vacíos
    public void verificarCampos() {
        if( TextUtils.isEmpty(etCorreo.getText())) {
            etCorreo.setError("El correo es requerido");
        }

        if( TextUtils.isEmpty(etClave.getText())) {
            etClave.setError("La clave es requerido");
        }
    }


    // Registra usuario y agrega a firebase
    public void registrar(View view) {
        String correo = etCorreo.getText().toString();
        String clave = etClave.getText().toString();

        verificarCampos();

        try {
            mAuth.createUserWithEmailAndPassword(correo, clave)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(getApplicationContext(), "Se registró el usuario correctamente.",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            String error = verificarClave(clave);
                            Toast.makeText(getApplicationContext(), "Fallo el registro, " + error,
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Actualiza la interfaz, despues de intentar validar o agregar usuario
    private void updateUI(FirebaseUser user) {
        if (user!=null) {
            Intent intento = new Intent(this, MainMenu.class);
            startActivity(intento);
        } else {
            Toast.makeText(getApplicationContext(), "Intente de nuevo.",
                    Toast.LENGTH_SHORT).show();
        }
    }

    // Si el usuario existe en la base procede a cargar la siguiente vista
    public void login(View view) {
        String correo = etCorreo.getText().toString();
        String clave = etClave.getText().toString();

        verificarCampos();

        try {
            mAuth.signInWithEmailAndPassword(correo, clave)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                FirebaseUser user = mAuth.getCurrentUser();
                                updateUI(user);
                            } else {
                                updateUI(null);
                            }
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}