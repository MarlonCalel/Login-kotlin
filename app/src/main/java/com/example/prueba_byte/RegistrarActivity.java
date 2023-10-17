package com.example.prueba_byte;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegistrarActivity extends AppCompatActivity {

    Button btnregistrar;
    TextView name, password, email;
    private FirebaseFirestore mFirestore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        mFirestore = FirebaseFirestore.getInstance();

        btnregistrar = findViewById(R.id.btnregistrar);
        name = findViewById(R.id.nombre);
        password = findViewById(R.id.contrasena);



        //Registrar usuario
        btnregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String btnregistra = btnregistrar.getText().toString().trim();
                String user = name.getText().toString().trim();
                String pass = password.getText().toString().trim();
                String emai = email.getText().toString().trim();

                if (user.isEmpty() || pass.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Ingrese los datos", Toast.LENGTH_SHORT).show();
                }
                    else if(user.length() < 8) {
                    Toast.makeText(getApplicationContext(), "El usuario debe tener 8 caracteres.", Toast.LENGTH_SHORT).show();
                    }
                    else if(pass.length() < 6){
                        Toast.makeText(getApplicationContext(), "La contraseña debe tener 6 caracteres.", Toast.LENGTH_SHORT).show();
                    }
                    else if (!verificarMayuscula(pass)){
                        Toast.makeText(getApplicationContext(), "La contraseña debe contener una letra mayúscula.", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        posUser(user, pass);
                    }


                }
            });
        }

        private boolean verificarMayuscula(String str){
            for (char c : str.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    return true;
                }
            }
            return false;
        }


        private void posUser(String name, String password) {
            Map<String, Object> map = new HashMap<>();
            map.put("Usuario", name);
            map.put("Password", password);

        }


        private boolean validaMay(String str) {
        for (char c : str.toCharArray()) {
        if (Character.isUpperCase(c)) {
        return true;
        }

        }
        return false;
        }

        private void posUsuario(String user, String pass) {
        Map<String, Object> map = new HashMap<>();
        map.put("Usuario", user);
        map.put("Password", pass);


            mFirestore.collection("usuarios")
                    .add(map)
                    .addOnSuccessListener(documentReference -> {
                        Toast.makeText(getApplicationContext(), "Usuario registrado exitosamente!", Toast.LENGTH_SHORT).show();
                        finish();
                    })
                    .addOnFailureListener(e -> {
                        Toast.makeText(getApplicationContext(), "Error al registrar: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    });
    }

    }